package cn.qdgxy.mybatis.mapper;

import cn.qdgxy.mybatis.po.User;
import cn.qdgxy.mybatis.po.UserCustom;
import cn.qdgxy.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

        sqlSession.close();
    }

    @Test
    public void findUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.findUserByName("小明");

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
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

        sqlSession.close();
    }

    /**
     * 通过包装类型查询用户信息
     *
     * @throws Exception 异常
     */
    @Test
    public void findUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 构造查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        userCustom.setSex("1");
        userQueryVo.setUserCustom(userCustom);
        // id集合
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(16);
        ids.add(22);
        userQueryVo.setIds(ids);

        List<User> users = userMapper.findUserList(userQueryVo);

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     * 返回查询记录总数
     *
     * @throws Exception 异常
     */
    @Test
    public void findUserCount() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 构造查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        userQueryVo.setUserCustom(userCustom);

        int count = userMapper.findUserCount(userQueryVo);

        System.out.println(count);

        sqlSession.close();
    }

    /**
     * 使用ResultMap映射对象
     *
     * @throws Exception 异常
     */
    @Test
    public void findUserListResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 构造查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        userQueryVo.setUserCustom(userCustom);

        List<User> users = userMapper.findUserListResultMap(userQueryVo);

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }


}