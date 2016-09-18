package cn.itcast.hibernate3.demo1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

/**
 * 抽取了hibernate的工具类的使用
 * 
 * @author 李欣
 *
 */
public class HibernateTest2 {

	/**
	 * 保存
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		Customer customer = new Customer();
		customer.setName("王五");
		customer.setAge(19);

		session.save(customer);

		tx.commit();
		session.close();
	}

	/**
	 * 保存或更新
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo2() throws Exception {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 保存
		// Customer customer = new Customer();
		// customer.setName("王五");
		// customer.setAge(18);

		// 更新
		Customer customer = new Customer();
		customer.setId(3);
		customer.setName("王五");
		customer.setAge(20);

		session.saveOrUpdate(customer);

		tx.commit();
		session.close();
	}

	/**
	 * HQL
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void demo5() throws Exception {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 1. 简单查询
		// List<Customer> customerList =
		// session.createQuery("from Customer").list();

		// 2. 条件查询
		// List<Customer> customerList = session
		// .createQuery("from Customer where name = ?")
		// .setParameter(0, "李四").list();

		// 3. 分页查询
		Query<Customer> query = session.createQuery("from Customer");
		query.setFirstResult(0); // 第一页
		query.setMaxResults(3); // 每页最大3条
		List<Customer> customerList = query.list();

		for (Customer customer : customerList) {
			System.out.println(customer);
		}

		tx.commit();
		session.close();
	}

	/**
	 * QBC
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo6() throws Exception {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 1. 简单查询
		// List<Customer> customerList = session.createCriteria(Customer.class)
		// .list();

		// 2. 多条件查询
		// Criteria criteria = session.createCriteria(Customer.class);
		// criteria.add(Restrictions.eq("name", "李四"));
		// List<Customer> customerList = criteria.list();

		// 3. 分页
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(3);
		List<Customer> customerList = criteria.list();

		for (Customer customer : customerList) {
			System.out.println(customer);
		}

		tx.commit();
		session.close();
	}

	/**
	 * 演示错误
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo7() throws Exception {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		Customer customer = session.get(Customer.class, 2);

		customer.setId(10);
		customer.setName("王五");
		session.update(customer);

		tx.commit();
		session.close();
	}

	/**
	 * 演示持久化类为final
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo8() throws Exception {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("unused")
		Customer customer = session.load(Customer.class, 1);
		
		
		tx.commit();
		session.close();
	}

}
