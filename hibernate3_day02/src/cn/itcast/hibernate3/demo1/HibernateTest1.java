package cn.itcast.hibernate3.demo1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

/**
 * Hibernate的测试类
 * 
 * @author 李欣
 *
 */
public class HibernateTest1 {

	/**
	 * 区分持久化对象的三种状态
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		// 1. 创建session
		Session session = HibernateUtils.openSession();
		// 2. 开启事务
		Transaction tx = session.beginTransaction();

		Book book = new Book(); // 瞬时态：没有唯一标识OID.没有纳入Session的管理
		book.setName("Hibernate开发");
		book.setAuthor("张三");
		book.setPrice(65d);

		session.save(book); // 持久态：有唯一标识OID.已经纳入到Session的管理.

		// 3. 提交事务
		tx.commit();
		// 4. 释放资源
		session.close();

		book.setName("开发"); // 托管态：持久化对象有唯一标识OID,没有纳入到Session管理.
	}

	/**
	 * 测试持久态的对象自动更新数据库
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo2() throws Exception {
		// 1. 创建session
		Session session = HibernateUtils.openSession();
		// 2. 开启事务
		Transaction tx = session.beginTransaction();

		// 获得持久态对象
		Book book = session.get(Book.class, 1);
		System.out.println(book);
		book.setName("struts2开发");

		// 3. 提交事务
		tx.commit();
		// 4. 释放资源
		session.close();
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo9() throws Exception {
		// 1. 创建session
		Session session = HibernateUtils.openSession();
		// 2. 开启事务
		Transaction tx = session.beginTransaction();

		// 3. 提交事务
		tx.commit();
		// 4. 释放资源
		session.close();
	}

}
