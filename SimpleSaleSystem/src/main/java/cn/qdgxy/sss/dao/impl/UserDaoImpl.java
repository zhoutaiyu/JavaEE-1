package cn.qdgxy.sss.dao.impl;

import cn.qdgxy.sss.dao.UserDao;
import cn.qdgxy.sss.mapper.UserMapper;
import cn.qdgxy.sss.po.User;
import cn.qdgxy.sss.po.UserCustom;
import cn.qdgxy.sss.po.UserExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Dao实现
 * create:2016-11-13 20:56
 *
 * @author 李欣
 * @version 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    /**
     * 按用户名查找用户
     *
     * @param userName 用户名
     * @return 用户
     */
    @Override
    public UserCustom findByUsername(String userName) throws Exception {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(userName);

        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.isEmpty()) {
            return null;
        }

        UserCustom userCustom = new UserCustom();
        BeanUtils.copyProperties(users.get(0), userCustom);
        return userCustom;
    }
}
