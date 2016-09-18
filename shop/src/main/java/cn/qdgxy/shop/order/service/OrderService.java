package cn.qdgxy.shop.order.service;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import cn.qdgxy.shop.order.dao.OrderDao;
import cn.qdgxy.shop.order.vo.Order;

@Transactional
public class OrderService {

	@Resource(name = "orderDao")
	private OrderDao orderDao;

	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public Integer add(Order order) {
		return orderDao.add(order);
	}

	/**
	 * 按ID查找订单
	 * 
	 * @param oid
	 */
	public Order findById(Integer oid) {
		return orderDao.findById(oid);
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
