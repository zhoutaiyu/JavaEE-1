package cn.qdgxy.mybatis.first;

import cn.qdgxy.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试
 *
 * @author 李欣
 * @version 2016-10-14 14:46
 */
public class MybatisFirst {

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

    /**
     * 通过ID获得一个对象
     */
    @Test
    public void testFindById() {
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession操作数据库
        // 第一个参数：statement的位置，等于namespace+statement的id
        // 第二个参数：传入的参数
        User user = null;
        try {
            user = sqlSession.selectOne("test.findUserById", 1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(user);
    }

    /**
     * 通过用户名获得多个对象
     */
    @Test
    public void testFindByUsername() {
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession操作数据库
        // 第一个参数：statement的位置，等于namespace+statement的id
        // 第二个参数：传入的参数
        List<User> users = null;
        try {
            users = sqlSession.selectList("test.findUserByName", "小明");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 插入用户
     */
    @Test
    public void testInsertUser() {
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession操作数据库
        // 插入用户
        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("1");

        try {
            sqlSession.insert("test.insertUser", user);

            // 需要提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        // 打印ID
        System.out.println(user);
    }


}
