package cn.itcast.hibernate3.demo1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

public class HibernateTest1 {

	/**
	 * 向数据库中插入一条记录
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		// 1.Hiberante框架加载核心配置文件(有数据库连接信息)
		Configuration configure = new Configuration().configure();
		// 2.创建一个SessionFactory.(获得Session--相当连接对象)
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// 3.获得Session对象.
		Session session = sessionFactory.openSession();
		// 4.默认的情况下,事务是不自动提交.
		Transaction tx = session.beginTransaction();

		// 5.业务逻辑操作
		// 向数据库中插入一条记录:
		Customer customer = new Customer();
		customer.setName("张三");
		customer.setAge(20);

		session.save(customer);

		// 6.事务提交
		tx.commit();
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}

	/**
	 * 按id查询
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo2() throws Exception {
		// 1.Hiberante框架加载核心配置文件(有数据库连接信息)
		Configuration configure = new Configuration().configure();
		// 2.创建一个SessionFactory.(获得Session--相当连接对象)
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// 3.获得Session对象.
		Session session = sessionFactory.openSession();
		// 4. 开启事物
		Transaction tx = session.beginTransaction();

		// 5.操作
		// get方法
		// Customer customer = session.get(Customer.class, 1);
		// System.out.println(customer);

		// load方法
		Customer customer = session.load(Customer.class, 1);
		System.out.println(customer);

		// 6.事务提交
		tx.commit();
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}

	/**
	 * 修改操作
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo3() throws Exception {
		// 1.Hiberante框架加载核心配置文件(有数据库连接信息)
		Configuration configure = new Configuration().configure();
		// 2.创建一个SessionFactory.(获得Session--相当连接对象)
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// 3.获得Session对象.
		Session session = sessionFactory.openSession();
		// 4. 开启事物
		Transaction tx = session.beginTransaction();

		// 5.操作

		// 5.1手动创建对象的方式
		// Customer customer = new Customer();
		// customer.setId(1);
		// customer.setName("李四");
		//
		// session.update(customer);

		// 5.2先查询在修改的方式(推荐方式)
		Customer customer = session.get(Customer.class, 1);
		customer.setName("张三");

		session.update(customer);

		// 6.事务提交
		tx.commit();
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}

	/**
	 * 删除操作
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo4() throws Exception {
		// 1.Hiberante框架加载核心配置文件(有数据库连接信息)
		Configuration configure = new Configuration().configure();
		// 2.创建一个SessionFactory.(获得Session--相当连接对象)
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// 3.获得Session对象.
		Session session = sessionFactory.openSession();
		// 4. 开启事物
		Transaction tx = session.beginTransaction();

		// 5.操作

		// 5.1手动创建对象的方式
		// Customer customer = new Customer();
		// customer.setId(2);
		//
		// session.delete(customer);

		// 5.2先查询在删除的方式(推荐方式)
		Customer customer = session.get(Customer.class, 2);
		session.delete(customer);

		// 6.事务提交
		tx.commit();
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}

	/**
	 * 查询所有
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void demo5() throws Exception {
		// 1.Hiberante框架加载核心配置文件(有数据库连接信息)
		Configuration configure = new Configuration().configure();
		// 2.创建一个SessionFactory.(获得Session--相当连接对象)
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// 3.获得Session对象.
		Session session = sessionFactory.openSession();
		// 4. 开启事物
		Transaction tx = session.beginTransaction();

		// 5.操作
		// ① 查询所有ID
		// Query<Customer> query = session.createQuery("form Customer");
		// List<Customer> list = query.list();

		// ② 按名称查找
		// Query<Customer> query =
		// session.createQuery("from Customer where name=?");
		// query.setParameter(0, "张三");

		// ③ 按参数查找
		Query<Customer> query = session
				.createQuery("from Customer where name=:aaa");
		query.setParameter("aaa", "张三");
		List<Customer> list = query.list();

		for (Customer customer : list) {
			System.out.println(customer);
		}

		// 6.事务提交
		tx.commit();
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}

}
