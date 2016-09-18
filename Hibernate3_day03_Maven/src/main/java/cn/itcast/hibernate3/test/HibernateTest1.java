package cn.itcast.hibernate3.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate3.demo1.Customer;
import cn.itcast.hibernate3.demo1.Order;
import cn.itcast.utils.HibernateUtils;

/**
 * Hibernate的检索方式的测试类:HQL
 * 
 * @author 姜涛
 * 
 */
public class HibernateTest1 {
	@Test
	// 命名查询:
	public void demo12(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.getNamedQuery("findAllCustomer").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
		session.close();
	}
	
	@Test
	// 投影查询:
	public void demo11(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 只查询所有客户的名称:
		/*Query query = session.createQuery("select c.cname from Customer c");
		List<String> list = query.list();
		for (String name : list) {
			System.out.println(name);
		}*/
		
		// 查询多个属性
		/*Query query = session.createQuery("select c.cid , c.cname from Customer c");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}*/
		
		// 构造器查询.
		Query query = session.createQuery("select new Customer(cid,cname) from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
		session.close();
	}
	
	@Test
	// 连接查询:
	public void demo10(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/*
		// 普通内连接:将数据封装到List<Object[]>
		Query query = session.createQuery("from Customer c inner join c.orders");
		query.list();
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}*/
		
		// 迫切内连接 使用distinct去掉重复值.
		Query query = session.createQuery("select distinct c from Customer c inner join fetch c.orders");
		List<Customer> list = query.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
		session.close();
	}
	
	@Test
	// 聚集函数查询:
	public void demo9() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Integer id = (Integer) session.createQuery("select max(id) from Customer").uniqueResult();
		
		Long count = (Long) session.createQuery("select count(*) from Customer").uniqueResult();
		
		List list = session.createQuery("select count(*) from Order o group by o.customer.cid").list();
		
		System.out.println(id);
		System.out.println(count);
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 条件查询:
	public void demo8() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		// 按位置绑定参数
		// List<Customer> list =
		// session.createQuery("from Customer where cname = ?").setParameter(0,
		// "美美").list();
		// List<Customer> list
		// =session.createQuery("from Customer where cname = ? and cid = ?")
		// .setParameter(0, "美美").setParameter(1, 2).list();

		// 按名称绑定参数:
		/*Query query = session
				.createQuery("from Customer where cname = :cname and cid = :cid");
		query.setParameter("cname", "童童");
		query.setParameter("cid", 3);*/
		
		Query query = session.createQuery("from Customer where cname like ?");
		query.setParameter(0, "%美%");
		List<Customer> list = query.list();
		
		System.out.println(list);

		tx.commit();
		session.close();
	}

	@Test
	// 唯一结果查询
	public void demo7() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		/*
		 * Customer customer = (Customer) session
		 * .createQuery("from Customer where id = ?").setParameter(0, 1)
		 * .uniqueResult(); System.out.println(customer);
		 */

		Long count = (Long) session.createQuery("select count(*) from Order")
				.uniqueResult();
		System.out.println(count);

		tx.commit();
		session.close();
	}

	@Test
	// 分页查询
	public void demo6() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("from Order");
		query.setFirstResult(20);// 从哪开始的.
		query.setMaxResults(10);// 每页显示多少条
		List<Order> list = query.list();
		for (Order order : list) {
			System.out.println(order);
		}
		tx.commit();
		session.close();
	}

	@Test
	// 排序查询
	public void demo5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		List<Customer> list = session.createQuery(
				"from Customer c order by c.cid desc").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
		session.close();
	}

	@Test
	// HQL:多态查询:
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		List list = session.createQuery("from java.lang.Object").list();
		System.out.println(list);

		tx.commit();
		session.close();
	}

	@Test
	// HQL:使用别名的检索方式:
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		// 使用as 起别名
		// List<Customer> list =
		// session.createQuery("from Customer as c").list();
		// as可以省略
		// List<Customer> list = session.createQuery("from Customer c").list();
		// 条件中使用别名
		// List<Customer> list =
		// session.createQuery("from Customer c where c.cname = ?").setParameter(0,
		// "美美").list();
		// HQL中不能select 后 写*号
		List<Customer> list = session.createQuery("select c from Customer c")
				.list();

		for (Customer customer : list) {
			System.out.println(customer);
		}

		tx.commit();
		session.close();
	}

	@Test
	// HQL检索:简单查询
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 简单查询
		// List<Customer> list = session.createQuery("from Customer").list();
		List<Customer> list = session
				.createQuery("from Customer where cname = ?")
				.setParameter(0, "童童").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}

		tx.commit();
		session.close();
	}

	@Test
	// 初始化数据:
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		Customer customer = new Customer();
		customer.setCname("童童");

		for (int i = 1; i <= 10; i++) {
			Order order = new Order();
			order.setAddr("回龙观" + i);

			order.setCustomer(customer);
			customer.getOrders().add(order);

			session.save(order);
		}
		session.save(customer);

		tx.commit();
		session.close();
	}
}
