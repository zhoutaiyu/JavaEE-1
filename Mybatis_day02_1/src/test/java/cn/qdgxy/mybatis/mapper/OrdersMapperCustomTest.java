package cn.qdgxy.mybatis.mapper;

import cn.qdgxy.mybatis.po.User;
import cn.qdgxy.mybatis.po_extend.OrderCustom;
import cn.qdgxy.mybatis.po.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ${DESCRIPTION}<br>
 * create:2016-10-18 20:19
 *
 * @author 李欣
 * @version 1.0
 */
public class OrdersMapperCustomTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 配置文件
        String resource = "SqlMapConfig.xml";

        // 加载配置文件到输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findOrderUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<OrderCustom> orderCustomList = ordersMapperCustom.findOrderUserList();
        for (OrderCustom orderCustom : orderCustomList) {
            System.out.println(orderCustom);
        }
    }

    @Test
    public void findOrderUserListResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> ordersList = ordersMapperCustom.findOrderUserListResultMap();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }

    @Test
    public void findOrderAndOrderDetails() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> ordersList = ordersMapperCustom.findOrderAndOrderDetails();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }

    @Test
    public void findUserOrderDetail() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<User> users = ordersMapperCustom.findUserOrderDetail();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findOrderUserListLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> orderList = ordersMapperCustom.findOrderUserListLazyLoading();

        // 这里执行延迟加载，要发出sql
        User user = orderList.get(0).getUser();
        System.out.println(user);
    }

}