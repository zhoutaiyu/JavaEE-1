package cn.qdgxy.mybatis.jdbc;

import org.junit.Test;

import java.sql.Connection;

/**
 * Created by 李欣 on 2016/10/13.
 */
public class JdbcUtilsTest {

    @Test
    public void getConnection() throws Exception {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void closeConnection() throws Exception {

    }

    @Test
    public void closeConnection1() throws Exception {

    }

    @Test
    public void closeConnection2() throws Exception {

    }

}