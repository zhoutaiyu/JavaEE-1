package cn.itcast.hibernate3.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate3.demo1.Customer;
import cn.itcast.hibernate3.demo1.Order;
import cn.itcast.utils.HibernateUtils;

public class HibernateTest6 {

	@Test
	// 查询缓存的测试
	public void demo9() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("select c.cname from Customer c");
		// 使用查询缓存:
		query.setCacheable(true);
		query.list();

		tx.commit();

		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();

		query = session.createQuery("select c.cname from Customer c");
		query.setCacheable(true);
		query.list();

		tx.commit();
	}

	@SuppressWarnings("unused")
	@Test
	// 更新时间戳区
	public void demo8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Customer customer = (Customer) session.get(Customer.class, 2);
		session.createQuery("update Customer set cname = '奶茶' where cid = 2")
				.executeUpdate();

		tx.commit();

		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();

		Customer customer2 = (Customer) session.get(Customer.class, 2);

		tx.commit();
	}

	@SuppressWarnings("all")
	@Test
	// 将内存中的数据写到硬盘
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		List<Order> list = session.createQuery("from Order").list();

		tx.commit();
	}

	@Test
	// 一级缓存的更新会同步到二级缓存:
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Customer customer = (Customer) session.get(Customer.class, 1);
		customer.setCname("芙蓉");

		tx.commit();

		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();

		Customer customer2 = (Customer) session.get(Customer.class, 1);

		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Test
	// iterate()方法可以查询所有信息.
	// iterate方法会发送N+1条SQL查询.但是会使用二级缓存的数据
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// N+1条SQL去查询.先查询所有的数量 再逐条查询
		Iterator<Customer> iterator = session.createQuery("from Customer")
				.iterate();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			System.out.println(customer);
		}

		tx.commit();

		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();

		iterator = session.createQuery("from Customer").iterate();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			System.out.println(customer);
		}

		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Test
	// 查询所有.Query接口的list()方法.
	// list()方法会向二级缓存中放数据,但是不会使用二级缓存中的数据.
	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// 查询所有客户:
		// list方法会向二级缓存中放入数据的.
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer.getCname());
		}
		tx.commit();

		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();

		// 没有发生SQL ,从二级缓存获取的数据.
		// Customer customer = (Customer) session.get(Customer.class, 1);

		// list()方法没有使用二级缓存的数据.
		list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer.getCname());
		}

		tx.commit();
	}

	@Test
	// 二级缓存的集合缓冲区特点:
	public void demo3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Customer customer = (Customer) session.get(Customer.class, 1);
		// 查询客户的订单.
		System.out.println("订单的数量:" + customer.getOrders().size());

		tx.commit();

		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();

		Customer customer2 = (Customer) session.get(Customer.class, 1);
		// 查询客户的订单.
		System.out.println("订单的数量:" + customer2.getOrders().size());

		tx.commit();
	}

	@SuppressWarnings("unused")
	@Test
	// 配置二级缓存的情况
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Customer customer1 = (Customer) session.get(Customer.class, 1);// 发送SQL.

		Customer customer2 = (Customer) session.get(Customer.class, 1);// 不发送SQL.

		System.out.println(customer1 == customer2);

		tx.commit();

		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();

		Customer customer3 = (Customer) session.get(Customer.class, 1);// 不发送SQL.
		Customer customer4 = (Customer) session.get(Customer.class, 1);// 不发送SQL.

		System.out.println(customer3 == customer4);

		tx.commit();
	}

	@SuppressWarnings("unused")
	@Test
	// 没有配置二级缓存的情况
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Customer customer1 = (Customer) session.get(Customer.class, 1);// 发送SQL.

		Customer customer2 = (Customer) session.get(Customer.class, 1);// 不发送SQL.

		tx.commit();

		session = HibernateUtils.getCurrentSession();
		tx = session.beginTransaction();

		Customer customer3 = (Customer) session.get(Customer.class, 1);// 发送SQL.

		tx.commit();
	}
}
