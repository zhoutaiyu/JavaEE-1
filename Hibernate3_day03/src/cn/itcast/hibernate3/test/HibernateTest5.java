package cn.itcast.hibernate3.test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate3.demo1.Customer;
import cn.itcast.utils.HibernateUtils;

/**
 * Hibernate的事务与并发的测试类:
 * @author 姜涛
 *
 */
public class HibernateTest5 {
	@Test
	public void demo9(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCname("李四");
		session.save(customer);
		
		tx.commit();
		// session.close();
	}
	
	@Test
	// 本地Session
	public void demo8(){
		Session session1 = HibernateUtils.getCurrentSession();
		Session session2 = HibernateUtils.getCurrentSession();
		
		System.out.println(session1 == session2);
	}	
	
	@Test
	// 本地Session
	public void demo7(){
		Session session1 = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		
		System.out.println(session1 == session2);
	}	
	
	@Test
	// 乐观锁解决丢失更新:
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class,3);
		customer.setAge(36);
		
		tx.commit();
		session.close();
	}	
	
	@Test
	// 乐观锁解决丢失更新:
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class,3);
		customer.setCname("铁男");
		
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// 悲观锁解决丢失更新:
	public void demo4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class,3,LockMode.UPGRADE);
		customer.setAge(36);
		
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// 悲观锁解决丢失更新:
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class,3,LockMode.UPGRADE);
		customer.setCname("铁男");
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 演示丢失更新
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, 3);
		customer.setAge(36);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 演示丢失更新
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, 3);
		customer.setCname("铁男");
		
		tx.commit();
		session.close();
	}
}
