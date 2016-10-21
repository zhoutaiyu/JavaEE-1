package cn.qdgxy.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}<br>
 * create:2016-10-21 19:50
 *
 * @author 李欣
 * @version ${VERSION}
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:Spring/applicationContext.xml"})
public class UserServiceByMapperImplTest {

    @Resource(name = "userServiceByMapperImpl")
    private UserService userService;

    @Test
    public void findUserById() throws Exception {
        System.out.println(userService.findUserById(1));
    }

}