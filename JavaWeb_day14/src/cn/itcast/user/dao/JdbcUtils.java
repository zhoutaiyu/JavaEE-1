package cn.itcast.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC
 * 
 * @author li119
 * @version 1.0
 */
public class JdbcUtils {
	
	private static Properties props = null;
	
	//只在JdbcUtils类被加载时执行一次
	static {
		// 给props进行初始化，即加载dbconfig.properties到pros对象中
		try {
			InputStream in = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		// 加载驱动类
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		/*
		 * 1. 加载配置文件
		 * 2. 加载驱动类
		 * 3. 调用DriverManger.getConnection()
		 */
		
		// 得到Connection
		return DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("username"), props.getProperty("password"));
	}

}
