package cn.qdgxy.shop.order.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.qdgxy.shop.order.vo.Order;

public class OrderDao extends HibernateDaoSupport {

	/**
	 * 保存订单
	 * 
	 * @param order
	 * @return
	 */
	public Integer add(Order order) {
		return (Integer) this.getHibernateTemplate().save(order);
	}

	/**
	 * 按ID查找订单
	 * 
	 * @param oid
	 * @return
	 */
	public Order findById(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

}
