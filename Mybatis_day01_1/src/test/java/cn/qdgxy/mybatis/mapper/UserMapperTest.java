package cn.qdgxy.mybatis.mapper;

import cn.qdgxy.mybatis.po.User;
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
 * create:2016-10-16 19:23
 *
 * @author 李欣
 * @version ${VERSION}
 */
public class UserMapperTest {

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
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserByuName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.findUserByName("小明");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("李三");

        int id = userMapper.insertUser(user);
        sqlSession.commit();

        System.out.println(id);
    }


}