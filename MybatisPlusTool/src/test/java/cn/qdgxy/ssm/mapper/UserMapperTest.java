package cn.qdgxy.ssm.mapper;

import cn.qdgxy.ssm.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 * create:2016-12-14 12:35
 *
 * @author 李欣
 * @version ${VERSION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testFun() throws Exception {
        User user = userMapper.selectById(10);

        System.out.println(user);
    }

}