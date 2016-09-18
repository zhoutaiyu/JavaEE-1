package cn.qdgxy.bookstore.order.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.qdgxy.bookstore.book.domain.Book;
import cn.qdgxy.bookstore.order.domain.Order;
import cn.qdgxy.bookstore.order.domain.OrderItem;
import cn.qdgxy.bookstore.util.page.dao.PagingDao;
import cn.qdgxy.bookstore.util.page.domain.PageBean;

public class OrderDao {

	private QueryRunner qr = new TxQueryRunner();
	private PagingDao<Order> pagingDao = new PagingDao<Order>();

	/**
	 * 插入订单
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		String sql = "INSERT INTO `orders` VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		/*
		 * 处理util的Date转换成sql的timestamp
		 */
		Timestamp orderTime = new Timestamp(order.getOrdertime().getTime());
		Object[] params = { order.getOid(), orderTime, order.getTotal(),
				order.getState(), order.getOwner().getUid(),
				order.getOwner().getConsignee(), order.getOwner().getPhone(),
				order.getOwner().getAdress() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 插入订单条目
	 * 
	 * @param orderItemList
	 */
	public void addOrderItemList(List<OrderItem> orderItemList) {
		/*
		 * 使用批处理完成
		 */
		String sql = "INSERT INTO `orderitem` VALUES(?, ?, ?, ?, ?)";
		// 把orderItemList转化为二维数组
		Object[][] params = new Object[orderItemList.size()][];
		// 把一个OrderItem对象转换成一个一维数组
		for (int i = 0; i < orderItemList.size(); i++) {
			OrderItem item = orderItemList.get(i);
			params[i] = new Object[] { item.getIid(), item.getCount(),
					item.getSubtotal(), item.getOrder().getOid(),
					item.getBook().getBid() };
		}
		try {
			qr.batch(sql, params); // 执行批处理
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找所有订单(分页)
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Order> findAll(int pageNumber, int pageSize) {
		try {
			String totalRecordSql = "SELECT COUNT(*) FROM `orders`";
			String beanListSql = "SELECT * FROM `orders` ORDER BY ordertime DESC LIMIT ?, ?";
			PageBean<Order> pb = pagingDao.findAll(qr, pageNumber, pageSize,
					totalRecordSql, beanListSql, Order.class);
			// 循环遍历每个Order，加载自己所有的OrderItem
			for (Order order : pb.getBeanList()) {
				loadOrderItems(order);
			}
			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按用户ID查询订单(分页)
	 * 
	 * @param uid
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Order> findByUid(String uid, int pageNumber, int pageSize) {
		try {
			String totalRecordSql = "SELECT COUNT(*) FROM `orders` WHERE uid=?";
			String beanListSql = "SELECT * FROM `orders` WHERE uid=? ORDER BY ordertime DESC LIMIT ?, ?";
			Object[] trParams = { uid };
			Object[] blParams = { uid, (pageNumber - 1) * pageSize, pageSize };

			PageBean<Order> pb = pagingDao.findByCondition(qr, pageNumber,
					pageSize, totalRecordSql, beanListSql, trParams, blParams,
					Order.class);
			// 循环遍历每个Order，加载自己所有的OrderItem
			for (Order order : pb.getBeanList()) {
				loadOrderItems(order);
			}

			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按订单状态查询订单(分页)
	 * 
	 * @param state
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Order> findByState(String state, int pageNumber,
			int pageSize) {
		try {
			String totalRecordSql = "SELECT COUNT(*) FROM `orders` WHERE state=?";
			String beanListSql = "SELECT * FROM `orders` WHERE state=? ORDER BY ordertime DESC LIMIT ?, ?";
			Object[] trParams = { state };
			Object[] blParams = { state, (pageNumber - 1) * pageSize, pageSize };

			PageBean<Order> pb = pagingDao.findByCondition(qr, pageNumber,
					pageSize, totalRecordSql, beanListSql, trParams, blParams,
					Order.class);
			// 循环遍历每个Order，加载自己所有的OrderItem
			for (Order order : pb.getBeanList()) {
				loadOrderItems(order);
			}

			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载指定订单的所有订单条目
	 * 
	 * @param order
	 * @throws SQLException
	 */
	private void loadOrderItems(Order order) throws SQLException {
		String sql = "SELECT * FROM orderitem i, book b WHERE i.bid=b.bid AND oid=?";
		// 这一行结果集对应的不是一个javabean，不能再使用BeanListHandler，而是MapListHandler
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(),
				order.getOid());
		/*
		 * mapList是多个map，每个map对应一行结果集 一行： {iid..., count=..., subtotal=...,
		 * oid=..., bid=7, bname=...,price=..., author=..., image=..., cid=...}
		 * ...
		 * 
		 * 需要使用一个Map生成两个对象：OrderItem、Book，再建立两者的关系（把Book设置给OrderItem）
		 */
		// 循环遍历每个Map，使用map生成两个对象，然后建立关系（最终结果一个OrderItem），把OrderItem保存起来
		List<OrderItem> orderItemList = toOrderItemList(mapList);
		order.setOrderItemList(orderItemList);
	}

	/**
	 * 把mapList中的每个Map转换成两个对象，并建立联系
	 * 
	 * @param mapList
	 * @return
	 */
	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for (Map<String, Object> map : mapList) {
			OrderItem item = toOrderItem(map);
			orderItemList.add(item);
		}
		return orderItemList;
	}

	/**
	 * 把一个Map转换成一个OrderItem对象
	 * 
	 * @param map
	 * @return
	 */
	private OrderItem toOrderItem(Map<String, Object> map) {
		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		orderItem.setBook(book);
		return orderItem;
	}

	/**
	 * 加载订单
	 * 
	 * @param oid
	 * @return
	 */
	public Order load(String oid) {
		try {
			// 1. 得到订单
			String sql = "SELECT * FROM `orders` WHERE oid=?";
			Order order = qr.query(sql, new BeanHandler<Order>(Order.class),
					oid);
			// 2. 加载商品条目
			loadOrderItems(order);
			return order;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过订单ID查询订单状态
	 * 
	 * @param oid
	 * @return
	 */
	public int getStateByOid(String oid) {
		String sql = "SELECT state FROM orders WHERE oid=? ";
		try {
			return (Integer) qr.query(sql, new ScalarHandler(), oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改订单状态
	 * 
	 * @param oid
	 * @return
	 */
	public void updateStateByOid(String oid, int state) {
		String sql = "UPDATE orders SET state=? WHERE oid=? ";
		try {
			qr.update(sql, state, oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询所有订单
	 * 
	 * @return
	 */
	@Deprecated
	public List<Order> findAll() {
		try {
			// 1. 通过uid查询当前用户所有的List<Order>
			String sql = "SELECT * FROM `orders` ORDER BY ordertime DESC";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(
					Order.class));
			// 2. 循环遍历每个Order，加载自己所有的OrderItem
			for (Order order : orderList) {
				loadOrderItems(order);
			}
			// 3. 返回订单列表
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按用户ID查询订单
	 * 
	 * @param uid
	 * @return
	 */
	@Deprecated
	public List<Order> findByUid(String uid) {
		try {
			// 1. 通过uid查询当前用户所有的List<Order>
			String sql = "SELECT * FROM `orders` WHERE uid=? ORDER BY ordertime DESC";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(
					Order.class), uid);
			// 2. 循环遍历每个Order，加载自己所有的OrderItem
			for (Order order : orderList) {
				loadOrderItems(order);
			}
			// 3. 返回订单列表
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按订单状态查询订单
	 * 
	 * @param state
	 * @return
	 */
	@Deprecated
	public List<Order> findByState(String state) {
		try {
			// 1. 通过uid查询当前用户所有的List<Order>
			String sql = "SELECT * FROM `orders` WHERE state=? ORDER BY ordertime DESC";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(
					Order.class), state);
			// 2. 循环遍历每个Order，加载自己所有的OrderItem
			for (Order order : orderList) {
				loadOrderItems(order);
			}
			// 3. 返回订单列表
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
