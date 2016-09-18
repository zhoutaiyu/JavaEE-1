package cn.itcast.hibernate3.test;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate3.demo1.Customer;
import cn.itcast.hibernate3.demo1.Order;
import cn.itcast.utils.HibernateUtils;

/**
 * Hibernate的抓取策略
 * 
 * @author 姜涛
 * 
 */
public class HibernateTest4 {
	@SuppressWarnings("unchecked")
	@Test
	// 批量抓取:
	// 从订单批量抓取客户
	// 在Customer.hbm.xml中<class>标签上设置batch-size=""
	public void demo9(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 查询所有的订单:
		List<Order> list = session.createQuery("from Order").list();
		for (Order order : list) {
			System.out.println(order.getCustomer().getCname());
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 批量抓取:
	// 从客户批量抓取订单
	// <set>标签上设置batch-size=""
	public void demo8(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		// 查询所有客户
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			for (Order order : customer.getOrders()) {
				System.out.println(order.getAddr());
			}
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 在Order.hbml.xml中<many-to-one>标签上配置fetch和lazy
	public void demo7(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/**
		 * fetch="select",lazy="false"
		 */
		// 查询一号订单
		//Order order = (Order) session.get(Order.class, 1);// 发送多条SQL查询关联对象
		// 查询一号订单所属客户的名称:
		//System.out.println("客户名称:"+order.getCustomer().getCname());// 不发送SQL
		
		/**
		 * fetch="select",lazy="proxy"
		 * proxy:查询关联对象的时候,是否采用延迟,由另一端的类级别延迟来决定.
		 * 	* Customer的<class>上配置的是lazy="true".检索的时候采用延迟
		 * 	* Customer的<class>上配置的是lazy="false".检索的时候不采用延迟
		 */
		// 查询一号订单
		Order order = (Order) session.get(Order.class, 1);// 发送多条SQL查询关联对象
		// 查询一号订单所属客户的名称:
		System.out.println("客户名称:"+order.getCustomer().getCname());// 不发送SQL
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 在Order.hbml.xml中<many-to-one>标签上配置fetch和lazy
	public void demo6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		/**
		 * fetch="join",lazy被忽略.
		 */
		// 查询一号订单
		Order order = (Order) session.get(Order.class, 1);// 发送一条迫切左外连接查询关联对象.
		// 查询一号订单所属客户的名称:
		System.out.println("客户名称:"+order.getCustomer().getCname());
		
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	// 在Customer.hbm.xml的<set>标签上配置fetch和lazy
	// fetch="subselect" 子查询
	public void demo5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		/**
		 * 配置fetch="subselect" lazy="true"
		 */
//		List<Customer> list = session.createQuery("from Customer").list();// 发送查询所有客户的SQL
//		for (Customer customer : list) {
//			System.out.println("客户订单数量:"+customer.getOrders().size());// 发送一个子查询去查询关联对象.
//		}
		
		// 使用子查询 查询多个的情况.
		/*Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println("客户订单数量:"+customer.getOrders().size());*/
		
		/**
		 * 配置fetch="subselect" lazy="false"
		 */
//		List<Customer> list = session.createQuery("from Customer").list();// 发送查询所有客户的SQL,发送一个子查询查询订单
//		for (Customer customer : list) {
//			System.out.println("客户订单数量:"+customer.getOrders().size());// 不发送SQL
//		}
		
		/**
		 * 配置fetch="subselect" lazy="extra"
		 */
		List<Customer> list = session.createQuery("from Customer").list();// 发送查询所有客户的SQL
		for (Customer customer : list) {
			System.out.println("客户订单数量:"+customer.getOrders().size());// 只发送统计客户订单数量的sql
			for (Order order : customer.getOrders()) {
				System.out.println(order.getAddr());
			}
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 在Customer.hbm.xml的<set>标签上配置fetch和lazy
	// fetch="select"
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		/**
		 * 配置fetch="select" lazy="true"
		 * * 发送多条SQL.默认值就是fetch="select" lazy="true"
		 */
		// 查询一号客户
		// Customer customer = (Customer) session.get(Customer.class, 1);//发送一条查询客户的SQL
		// 查看一号客户的订单的数量:
		// System.out.println("订单的数量:" + customer.getOrders().size());//又发送一条查询订单的SQL
		
		/**
		 * 配置fetch="select" lazy="false"
		 */
		// 查询一号客户
		//Customer customer = (Customer) session.get(Customer.class, 1);//发送多条SQL查询
		// 查看一号客户的订单的数量:
		//System.out.println("订单的数量:" + customer.getOrders().size());//不发送SQL
		
		/**
		 * 配置fetch="select" lazy="extra"
		 * * extra:及其懒惰的.
		 */
		// 查询一号客户
		Customer customer = (Customer) session.get(Customer.class, 1);// 发送一条查询客户的SQL
		// 查看一号客户的订单的数量:
		System.out.println("订单的数量:" + customer.getOrders().size());// 查询订单的数量:select count(oid) from orders o where o.cid = ? 
		
		for (Order order : customer.getOrders()) {
			System.out.println(order);
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	// 在Customer.hbm.xml的<set>标签上配置fetch和lazy
	// fetch="join",lazy的取值就会被忽略.
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 查询一号客户
		Customer customer = (Customer) session.get(Customer.class, 1);// 发送了一条迫切左外连接的SQL
		
		// 查看一号客户的订单的数量:
		System.out.println("订单的数量:" + customer.getOrders().size());// 不发送SQL.
		
		tx.commit();
		session.close();
	}

	@Test
	// 默认的情况下 没有配置任何信息
	// 发送多条SQL查询其关联对象.
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 查询一号客户
		Customer customer = (Customer) session.get(Customer.class, 1);// 发送一条查询客户的SQL.

		// 查看一号客户的订单的数量:
		System.out.println("订单的数量:" + customer.getOrders().size());// 使用订单的时候,又会发送一条SQL查询

		tx.commit();
		session.close();
	}

	@Test
	// 区分立即和延迟检索
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		// 立即检索
		// Customer customer = (Customer) session.get(Customer.class, 1);

		// System.out.println(customer.getCname());

		// 延迟检索:
		Customer customer = (Customer) session.load(Customer.class, 1);

		Hibernate.initialize(customer);

		System.out.println(customer.getCname());

		tx.commit();
		session.close();
	}
}
