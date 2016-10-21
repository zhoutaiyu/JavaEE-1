package cn.qdgxy.mybatis.mapper;

import cn.qdgxy.mybatis.po.User;

/**
 * 整合开发mapper代理方法<br>
 * create:2016-10-16 17:43
 *
 * @author 李欣
 * @version 1.0
 */
public interface UserMapper {

    //根据id查询用户信息
    User findUserById(int id);

}
