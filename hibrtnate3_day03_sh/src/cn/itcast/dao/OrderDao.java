package cn.itcast.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.utils.HibernateUtils;
import cn.itcast.vo.Order;

public class OrderDao {

	/**
	 * 查找用户订单
	 * 
	 * @param cid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Order> findById(Integer cid) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Query query = session
				.createQuery("from Order o where o.customer.cid=?");
		query.setParameter(0, cid);
		List<Order> list = query.list();

		tx.commit();
		return list;
	}

}
