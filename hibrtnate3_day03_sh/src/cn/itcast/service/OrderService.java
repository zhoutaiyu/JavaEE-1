package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.OrderDao;
import cn.itcast.vo.Order;

public class OrderService {

	private OrderDao orderDao = new OrderDao();

	/**
	 * 查找用户订单
	 * 
	 * @param cid
	 * @return
	 */
	public List<Order> findById(Integer cid) {
		return orderDao.findById(cid);
	}

}
