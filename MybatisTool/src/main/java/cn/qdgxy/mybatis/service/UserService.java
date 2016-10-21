package cn.qdgxy.mybatis.service;

import cn.qdgxy.mybatis.po.User;

/**
 * 用户Service接口<br>
 * create:2016-10-21 13:34
 *
 * @author 李欣
 */
public interface UserService {

    User findUserById(int id);

}
