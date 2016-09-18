package cn.itcast.hibernate3.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate3.demo1.Customer;
import cn.itcast.utils.HibernateUtils;

/**
 * Hibernate的查询方式:SQL
 * 
 * @author 姜涛
 * 
 */
public class HibernateTest3 {
	@Test
	public void demo1() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

		/*List<Object[]> list = session.createSQLQuery("select * from customer")
				.list();
		
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}*/
		
		SQLQuery query = session.createSQLQuery("select * from customer");
		query.addEntity(Customer.class);
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
		session.close();
	}
}
