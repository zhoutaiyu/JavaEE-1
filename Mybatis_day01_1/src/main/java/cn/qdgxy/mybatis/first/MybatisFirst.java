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
        // 通过sqlSession操作数据库
        // 第一个参数：statement的位置，等于namespace+statement的id
        // 第二个参数：传入的参数
        User user = null;
        // 通过sqlSessionFactory创建sqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            user = sqlSession.selectOne("test.findUserById", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

    /**
     * 通过用户名获得多个对象
     */
    @Test
    public void testFindByUsername() {
        // 通过sqlSession操作数据库
        // 第一个参数：statement的位置，等于namespace+statement的id
        // 第二个参数：传入的参数
        List<User> users = null;

        // 通过sqlSessionFactory创建sqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            users = sqlSession.selectList("test.findUserByName", "小明");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (users != null) {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    /**
     * 插入用户
     */
    @Test
    public void testInsertUser() throws Exception {
        // 通过sqlSession操作数据库
        // 插入用户
        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("1");

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            sqlSession.insert("test.insertUser", user);

            // 需要提交事务
            sqlSession.commit();
        }

        // 打印ID
        System.out.println(user);
    }

    /**
     * 删除用户
     */
    @Test
    public void testdeleteUser() {
        // 通过sqlSessionFactory创建sqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            sqlSession.delete("test.deleteUser", 28);

            // 需要提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新用户
     */
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(26);
        user.setUsername("王五");
        user.setAddress("上海");
        user.setBirthday(new Date());
        user.setSex("1");

        // 通过sqlSessionFactory创建sqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            sqlSession.update("test.updateUser", user);

            // 需要提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
