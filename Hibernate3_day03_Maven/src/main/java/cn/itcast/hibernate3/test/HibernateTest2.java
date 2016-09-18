package cn.itcast.hibernate3.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.hibernate3.demo1.Customer;
import cn.itcast.hibernate3.demo1.Order;
import cn.itcast.utils.HibernateUtils;

/**
 * Hibernate检索方式测试类:QBC.
 * QBC:Query By Criteria
 * @author 姜涛
 *
 */
public class HibernateTest2 {
	
	@Test
	// 离线条件查询:
	public void demo5(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.eq("cname", "童童"));
		criteria.add(Restrictions.eq("cid", 3));
		
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = criteria.getExecutableCriteria(session).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 分页查询
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Order.class);
		criteria.setFirstResult(10);
		criteria.setMaxResults(10);
		List<Order> list = criteria.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 条件查询:
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		//criteria.add(Restrictions.eq("cname", "美美"));
		//criteria.add(Restrictions.eq("cid", 2));
		criteria.add(Restrictions.like("cname", "%美%"));
		
		//List<Customer> list = criteria.list();
		// System.out.println(list);
		Customer customer = (Customer) criteria.uniqueResult();
		System.out.println(customer);
		tx.commit();
		session.close();
	}
	
	@Test
	// QBC:排序查询
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 查询所有:
		Criteria criteria = session.createCriteria(Order.class);
		criteria.addOrder(org.hibernate.criterion.Order.desc("oid"));
		List<Order> list = criteria.list();
		for (Order order : list) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	// QBC:简单查询
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 查询所有:
		List<Customer> list = session.createCriteria(Customer.class).list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
}
