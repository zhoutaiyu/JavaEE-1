package cn.qdgxy.mybatis.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC小工具
 *
 * @author 李欣
 * @version 2016-10-13 20:29
 */
public class JdbcUtils {

    private static Properties props = null;

    // 只在JdbcUtils类被加载时执行一次
    static {
        // 给props进行初始化，即加载dbconfig.properties到props对象中
        try {
            InputStream in = JdbcUtils.class.getClassLoader()
                    .getResourceAsStream("dbconfig.properties");
            props = new Properties();
            props.load(in);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 加载驱动类
        try {
            Class.forName(props.getProperty("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 得到连接
     *
     * @return Connection
     * @throws SQLException SQL异常
     */
    public static Connection getConnection() throws SQLException {
        // 1. 加载配置文件
        // 2. 加载驱动类
        // 3. 调用DriverManger.getConnection()
        return DriverManager.getConnection(props.getProperty("jdbc.url"),
                props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
    }

    /**
     * 关闭连接
     *
     * @param conn Connection
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭连接
     *
     * @param conn Connection
     * @param stmt Statement
     */
    public static void closeConnection(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭连接
     *
     * @param conn Connection
     * @param stmt Statement
     * @param rs   ResultSet
     */
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
