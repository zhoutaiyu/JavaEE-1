package cn.qdgxy.mybatis.service;

import cn.qdgxy.mybatis.dao.UserDao;
import cn.qdgxy.mybatis.po.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户Service<br>
 * create:2016-10-21 13:25
 *
 * @author 李欣
 * @version 1.0
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

}
