package cn.itcast.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.utils.HibernateUtils;
import cn.itcast.vo.Customer;

public class CustomerDao {

	/**
	 * 查询所有客户
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		List<Customer> list = session.createQuery("from Customer").list();

		tx.commit();
		return list;
	}

	/**
	 * 删除
	 * 
	 * @param customer
	 */
	public void delete(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// 先查询再删除 级联删除
		Customer _customer = (Customer) session.get(Customer.class,
				customer.getCid());
		session.delete(_customer);

		tx.commit();
	}

}
