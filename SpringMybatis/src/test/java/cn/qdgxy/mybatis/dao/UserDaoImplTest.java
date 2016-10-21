package cn.qdgxy.mybatis.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ${DESCRIPTION}<br>
 * create:2016-10-21 9:39
 *
 * @author 李欣
 * @version ${VERSION}
 */
public class UserDaoImplTest {

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        // 创建Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring/applicationContext.xml");

        userDao = applicationContext.getBean(UserDaoImpl.class);
    }

    @Test
    public void findUserById() throws Exception {
        System.out.println(userDao.findUserById(1));
    }

}