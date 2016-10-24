package cn.qdgxy.mybatis.mapper;

import cn.qdgxy.mybatis.po.User;
import cn.qdgxy.mybatis.po.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}<br>
 * create:2016-10-24 9:43
 *
 * @author 李欣
 * @version ${VERSION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    /**
     * 统计数量
     *
     * @throws Exception 异常
     */
    @Test
    public void countByExample() throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike("%小明%");

        System.out.println("名字中含有小明的人数：" + userMapper.countByExample(userExample));

        System.out.println("总人数：" + userMapper.countByExample(null));
    }

    @Test
    public void deleteByExample() throws Exception {

    }

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    /**
     * 插入 不判断属性是否为空，直接插入所有属性
     *
     * @throws Exception 异常
     */
    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUsername("张三");
        user.setSex("男");

        int flag = userMapper.insert(user);
        System.out.println("是否成功插入：" + flag);
        System.out.println("插入ID为：" + user.getUid());
    }

    /**
     * 插入 判断属性是否为空，插入不为空的属性
     *
     * @throws Exception 异常
     */
    @Test
    public void insertSelective() throws Exception {
        User user = new User();
        user.setUsername("张三");
        user.setSex("1");

        int flag = userMapper.insertSelective(user);
        System.out.println("是否成功插入：" + flag);
        System.out.println("插入ID为：" + user.getUid());
    }

    @Test
    public void selectByExample() throws Exception {

    }

    /**
     * 按ID查找
     *
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKey() throws Exception {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void updateByExampleSelective() throws Exception {

    }

    @Test
    public void updateByExample() throws Exception {

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}