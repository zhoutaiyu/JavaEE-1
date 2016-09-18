package cn.itcast_my.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;
import cn.itcast_my.vo.Customer;
import cn.itcast_my.vo.Order;

/**
 * Hibernate的检索方式:
 * 
 * @author 姜涛
 * 
 */
public class HibernateDemo1 {
	@Test
	/*
	 * 离线条件查询
	 */
	public void demo15(){
		// web层的封装
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.eq("cname", "小明"));
		criteria.add(Restrictions.eq("cid", 2));
		
		// 传递到DAO层
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c1 = criteria.getExecutableCriteria(session);
		List<Customer> list = c1.list();
		
		System.out.println(list);
		tx.commit();
		session.close();
	}
	
	@Test
	/*
	 * 命名查询
	 */
	public void demo14(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.getNamedQuery("findAll").list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	/*
	 * 聚集函数
	 */
	public void demo13(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Long count = (Long) session.createQuery("select count(*) from Order")
				.uniqueResult();
		System.out.println(count);
		
		tx.commit();
		session.close();
	}
	
	@Test
	/*
	 * 多表查询:
	 */
	public void demo12(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 内连接查询的是两个表的交集部分:
		/*Query query = session.createQuery("from Customer c inner join c.orders");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}*/
		
		// 迫切内连接:使用一个关键字 fetch(HQL)
		Query query = session.createQuery("select distinct c from Customer c  inner join fetch c.orders");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	/*
	 * 模糊查询:
	 */
	public void demo11() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// HQL
		/*Query query = session.createQuery("from Customer where cname like ?");
		query.setParameter(0, "小%");
		List<Customer> list = query.list();
		System.out.println(list);*/
		
		// QBC:
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("cname", "大%"));
		List<Customer> list = criteria.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}

	@Test
	/*
	 * QBC条件检索
	 */
	public void demo10() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		/*
		 * List<Customer> list = session.createCriteria(Customer.class)
		 * .add(Restrictions.eq("cname", "小明")).list();
		 * System.out.println(list);
		 */

		List<Customer> list = session.createCriteria(Customer.class)
				.add(Restrictions.eq("cname", "小明"))
				.add(Restrictions.eq("cid", 2)).list();
		System.out.println(list);

		tx.commit();
		session.close();
	}

	@Test
	/*
	 * 投影操作:查询对象的某几个属性
	 */
	public void demo9() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 查询客户的名称:
		/*
		 * List<Object> list = session.createQuery(
		 * "select c.cname from Customer c").list(); System.out.println(list);
		 */

		/*
		 * List<Object[]> list = session.createQuery(
		 * "select c.cid,c.cname from Customer c").list(); for (Object[] objects
		 * : list) { System.out.println(Arrays.toString(objects)); }
		 */

		List<Customer> list = session.createQuery(
				"select new Customer(cname) from Customer").list();
		System.out.println(list);

		tx.commit();
		session.close();
	}

	@Test
	/*
	 * 绑定参数
	 */
	public void demo8() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// HQL的参数绑定:
		// 1.使用?号方式绑定
		/*
		 * Query query = session.createQuery("from Customer where cname = ?");
		 * query.setString(0, "小沈"); List<Customer> list = query.list();
		 * System.out.println(list);
		 */

		/*
		 * Query query =
		 * session.createQuery("from Customer where cname = ? and cid =?");
		 * query.setString(0, "小沈"); query.setInteger(1,3); List<Customer> list
		 * = query.list(); System.out.println(list);
		 */

		// 2.使用名称的方式绑定
		/*
		 * Query query = session
		 * .createQuery("from Customer where cname=:name and cid=:id");
		 * query.setString("name", "小沈"); query.setInteger("id", 3);
		 * query.setParameter("name", "小沈"); query.setParameter("id", 3);
		 * List<Customer> list = query.list(); System.out.println(list);
		 */
		Customer customer = new Customer();
		customer.setCid(1);

		List<Order> list = session
				.createQuery("from Order o where o.customer = ?")
				.setEntity(0, customer).list();
		for (Order order : list) {
			System.out.println(order);
		}

		tx.commit();
		session.close();
	}

	@Test
	/*
	 * 检索单个对象
	 */
	public void demo7() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// HQL获取单个对象
		/*
		 * Customer customer = (Customer) session
		 * .createQuery("from Customer where cname = ?") .setString(0,
		 * "小明").uniqueResult();
		 * 
		 * System.out.println(customer);
		 */

		// QBC方式获取单个对象
		Customer customer = (Customer) session.createCriteria(Customer.class)
				.add(Restrictions.eq("cname", "小明")).uniqueResult();
		System.out.println(customer);

		tx.commit();
		session.close();
	}

	@Test
	/*
	 * 分页查询
	 */
	public void demo6() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 1.HQL进行分页:
		/*
		 * Query query = session.createQuery("from Order");
		 * query.setFirstResult(20); query.setMaxResults(10); List<Order> list =
		 * query.list(); for (Order order : list) { System.out.println(order); }
		 */

		// 2.QBC进行分页:
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
	/*
	 * 排序:
	 */
	public void demo5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 1使用HQL进行排序
		/*
		 * List<Customer> list = session.createQuery(
		 * "from Customer c order by c.id desc").list(); for (Customer customer
		 * : list) { System.out.println(customer); }
		 */

		// 2.使用QBC的方式进行排序
		List<Customer> list = session.createCriteria(Customer.class)
				.addOrder(org.hibernate.criterion.Order.desc("id")).list();
		for (Customer customer : list) {
			System.out.println(customer);
		}

		tx.commit();
		session.close();
	}

	@Test
	/*
	 * 多态检索
	 */
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		List<Object> list = session.createQuery("from java.lang.Object").list();
		System.out.println(list);

		tx.commit();
		session.close();
	}

	@Test
	/*
	 * 使用别名:
	 */
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 使用别名
		// 别名as可以省略
		/*
		 * List<Customer> list = session.createQuery("from Customer  c").list();
		 * System.out.println(list);
		 */

		// 使用别名:带参数
		/*
		 * List<Customer> list = session
		 * .createQuery("from Customer as c where c.cname = ?") .setString(0,
		 * "小沈").list(); System.out.println(list);
		 */

		// 不支持 select * from Customer写法.可以写成 select 别名 from Customer as 别名;
		List<Customer> list = session.createQuery("select c from Customer c")
				.list();
		System.out.println(list);

		tx.commit();
		session.close();
	}

	@Test
	/*
	 * 简单的查询:查询所有数据
	 */
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 使用HQL查询所有客户信息:
		/*
		 * List<Customer> list = session.createQuery("from Customer").list();
		 * for (Customer customer : list) { System.out.println(customer); }
		 */

		// 使用QBC的方式查询所有记录:
		/*
		 * List<Customer> list = session.createCriteria(Customer.class).list();
		 * for (Customer customer : list) { System.out.println(customer); }
		 */

		// 3.使用SQL语句查询所有记录:
		/*
		 * List<Object[]> list =
		 * session.createSQLQuery("select * from customer").list(); for
		 * (Object[] objects : list) {
		 * System.out.println(Arrays.toString(objects)); }
		 */

		// 3.使用SQL查询所有记录:封装到实体对象中
		List<Customer> list = session.createSQLQuery("select * from customer")
				.addEntity(Customer.class).list();
		for (Customer customer : list) {
			System.out.println(customer);
		}

		tx.commit();
		session.close();
	}

	@Test
	/*
	 * 初始化数据
	 */
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		Customer customer = new Customer();
		customer.setCname("小沈");

		for (int i = 1; i <= 10; i++) {
			Order order = new Order();
			order.setAddress("山东" + i);
			order.setCustomer(customer);

			customer.getOrders().add(order);
		}

		session.save(customer);

		tx.commit();
		session.close();
	}
}
