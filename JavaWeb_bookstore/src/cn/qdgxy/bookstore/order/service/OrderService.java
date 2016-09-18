package cn.qdgxy.bookstore.order.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.jdbc.JdbcUtils;
import cn.qdgxy.bookstore.order.dao.OrderDao;
import cn.qdgxy.bookstore.order.domain.Order;
import cn.qdgxy.bookstore.util.page.domain.PageBean;

public class OrderService {

	private OrderDao orderDao = new OrderDao();

	/**
	 * 添加订单
	 * 
	 * @param order
	 */
	public void add(Order order) {
		/*
		 * 需要处理事务
		 */
		try {
			// 开启事务
			JdbcUtils.beginTransaction();

			orderDao.addOrder(order);
			orderDao.addOrderItemList(order.getOrderItemList());

			// 提交事务
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			// 回滚事务
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
			}
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
		return orderDao.findAll();
	}

	/**
	 * 查找所有订单(分页)
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Order> findAll(int pageNumber, int pageSize) {
		return orderDao.findAll(pageNumber, pageSize);
	}

	/**
	 * 按订单状态查询订单
	 * 
	 * @param state
	 * @return
	 */
	@Deprecated
	public List<Order> findByState(String state) {
		return orderDao.findByState(state);
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
		return orderDao.findByState(state, pageNumber, pageSize);
	}

	/**
	 * 我的订单
	 * 
	 * @param uid
	 * @return
	 */
	@Deprecated
	public List<Order> myOrders(String uid) {
		return orderDao.findByUid(uid);
	}

	/**
	 * 我的订单(分页)
	 * 
	 * @param uid
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Order> myOrders(String uid, int pageNumber, int pageSize) {
		return orderDao.findByUid(uid, pageNumber, pageSize);
	}

	/**
	 * 加载订单
	 * 
	 * @param oid
	 * @return
	 */
	public Order load(String oid) {
		return orderDao.load(oid);
	}

	/**
	 * 确认收货
	 * 
	 * @param oid
	 * @throws OrderException
	 */
	public void confirm(String oid) throws OrderException {
		int state = orderDao.getStateByOid(oid);
		// 校验订单状态
		if (state != 3) {
			throw new OrderException("YOU ARE LOSER!");
		}
		// 修改订单状态，完成业务操作
		orderDao.updateStateByOid(oid, 4);
	}

	/**
	 * 支付
	 * 
	 * @param oid
	 */
	public void pay(String oid) {
		int state = orderDao.getStateByOid(oid);
		// 校验订单状态，只有状态为1才进行业务操作
		if (state == 1) {
			// 修改订单状态为2
			orderDao.updateStateByOid(oid, 2);
		}
	}

	/**
	 * 发货
	 * 
	 * @param oid
	 */
	public void ship(String oid) {
		int state = orderDao.getStateByOid(oid);
		// 校验订单状态，只有状态为2才进行业务操作
		if (state == 2) {
			// 修改订单状态为3
			orderDao.updateStateByOid(oid, 3);
		}
	}

}
