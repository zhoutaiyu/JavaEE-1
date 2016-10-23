package cn.qdgxy.mybatis.mapper;

import cn.qdgxy.mybatis.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}<br>
 * create:2016-10-21 19:13
 *
 * @author 李欣
 * @version ${VERSION}
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserMapperTest {

    @Resource
    private ApplicationContext applicationContext;

    @Test
    public void findUserById() throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

}