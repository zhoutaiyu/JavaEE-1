package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate抽取工具类
 * @author 姜涛
 *
 */
public class HibernateUtils {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static{
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) {
		openSession();
	}
}
