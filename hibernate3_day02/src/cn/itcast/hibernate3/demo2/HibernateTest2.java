package cn.itcast.hibernate3.demo2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

/**
 * 一对多测试
 * 
 * @author 李欣
 *
 */
public class HibernateTest2 {

	private Session session = null;
	private Transaction tx = null;

	@Before
	public void init() {
		// 1. 创建session
		session = HibernateUtils.openSession();
		// 2. 开启事务
		tx = session.beginTransaction();
	}

	@After
	public void destory() {
		// 3. 提交事务
		tx.commit();
		// 4. 释放资源
		session.close();
	}

	/**
	 * 插入一个客户 两个订单
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		// 定义一个客户
		Customer customer = new Customer();
		customer.setCname("张三");

		// 定义两个订单
		Order order1 = new Order();
		order1.setAddress("北京");

		Order order2 = new Order();
		order2.setAddress("上海");

		// 建立关系
		order1.setCustomer(customer);
		order2.setCustomer(customer);

		customer.getOrders().add(order1);
		customer.getOrders().add(order2);

		session.save(customer);
		session.save(order1);
		session.save(order2);
	}

	/**
	 * 保存客户与订单的时候是否只保存一方?没有配置不可以
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo2() throws Exception {
		// 定义一个客户
		Customer customer = new Customer();
		customer.setCname("王五");

		// 定义订单
		Order order1 = new Order();
		order1.setAddress("上海");

		// 建立关系
		order1.setCustomer(customer);
		customer.getOrders().add(order1);

		session.save(customer);
		// session.save(order1);
	}

	/**
	 * 保存客户级联订单
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo3() throws Exception {
		// 定义一个客户
		Customer customer = new Customer();
		customer.setCname("李四");

		// 定义订单
		Order order1 = new Order();
		order1.setAddress("北京");

		// 建立关系
		order1.setCustomer(customer);
		customer.getOrders().add(order1);

		session.save(customer);
	}

	/**
	 * 保存订单级联客户
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo4() throws Exception {
		// 定义一个客户
		Customer customer = new Customer();
		customer.setCname("李四");

		// 定义订单
		Order order1 = new Order();
		order1.setAddress("北京");

		// 建立关系
		order1.setCustomer(customer);
		customer.getOrders().add(order1);

		session.save(order1);
	}

	/**
	 * 测试对象导航
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo5() throws Exception {
		// 定义一个客户
		Customer customer = new Customer();
		customer.setCname("李四");

		// 定义三个订单
		Order order1 = new Order();
		order1.setAddress("北京");

		Order order2 = new Order();
		order2.setAddress("上海");

		Order order3 = new Order();
		order3.setAddress("广东");

		// 建立关系
		order1.setCustomer(customer);

		customer.getOrders().add(order2);
		customer.getOrders().add(order3);

		// session.save(order1); // 发送4条insert
		// session.save(customer); // 发送3条insert
		session.save(order2); // 发送1条insert
	}

	/**
	 * 测试级联删除
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo6() throws Exception {
		// 默认将外键置为null 再删除
		Customer customer = session.get(Customer.class, 1);
		session.delete(customer);
	}

	/**
	 * 级联删除：删除客户级联删除订单
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo7() throws Exception {
		// 级联删除：先查询再删除
		// 在set标签上配置
		Customer customer = session.get(Customer.class, 1);
		session.delete(customer);
	}

	/**
	 * 级联删除：删除订单级联删除客户
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo8() throws Exception {
		// 级联删除：先查询再删除
		// 在set标签上配置
		Order order = session.get(Order.class, 1);
		session.delete(order);
	}

	/**
	 * 孤儿删除
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo9() throws Exception {
		// 1号客户与1号订单解除关系
		Customer customer = session.get(Customer.class, 1);

		Order order = session.get(Order.class, 1);

		customer.getOrders().remove(order);
	}

	/**
	 * 双维护产生的多余SQL语句
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo10() throws Exception {
		Customer customer = session.get(Customer.class, 1);
		Order order = session.get(Order.class, 2);

		customer.getOrders().add(order);
		order.setCustomer(customer);
	}

	/**
	 * 区分cascade和inverse
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo11() throws Exception {
		Customer customer = new Customer();
		customer.setCname("薛qi");

		Order order = new Order();
		order.setAddress("深圳qi");

		customer.getOrders().add(order);

		session.save(customer);
	}

}
