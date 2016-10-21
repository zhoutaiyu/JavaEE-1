package cn.qdgxy.mybatis.service;

import cn.qdgxy.mybatis.mapper.UserMapper;
import cn.qdgxy.mybatis.po.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户Service，Mapper实现， 推荐这一种<br>
 * create:2016-10-21 13:25
 *
 * @author 李欣
 * @version 1.0
 */
@Transactional
@Service
public class UserServiceByMapperImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(1);
    }

}
