package cn.qdgxy.bookstore.admin.dao;

import java.sql.*;

/**
 * 连接数据库
 * 
 * @author qq477
 *
 */
public class DBConnection {

	private static final String DRIVERNAME = "com.mysql.jdbc.Driver"; // 驱动程序名
	private static final String USERNAME = "root"; // 数据库用户名
	private static final String PASSWORD = "1234"; // 密码
	private static final String DBNAME = "bookstore"; // 数据库名
	private static final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;

	/**
	 * 连接数据库
	 * 
	 * @return
	 */
	public static Connection getDBConnection() {
		try {
			Connection conn = null;
			Class.forName(DRIVERNAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 关闭数据库
	 * 
	 * @param conn
	 * @param pstmt
	 */
	public static void closeDBConnection(Connection conn,
			PreparedStatement pstmt) {
		closeDBConnection(conn, pstmt, null);
	}

	/**
	 * 关闭数据库
	 * 
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void closeDBConnection(Connection conn,
			PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
