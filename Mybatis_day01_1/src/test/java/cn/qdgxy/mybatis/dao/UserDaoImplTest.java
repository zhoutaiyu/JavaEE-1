package cn.qdgxy.mybatis.dao;

import cn.qdgxy.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ${DESCRIPTION}
 * create:2016-10-16 17:50
 *
 * @author 李欣
 * @version ${VERSION}
 */
public class UserDaoImplTest {

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
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

}