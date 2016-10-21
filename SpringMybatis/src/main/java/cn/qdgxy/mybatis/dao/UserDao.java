package cn.qdgxy.mybatis.dao;

import cn.qdgxy.mybatis.po.User;

/**
 * 用户Dao 接口<br>
 * create:2016-10-16 17:43
 *
 * @author 李欣
 * @version 1.0
 */
public interface UserDao {

    //根据id查询用户信息
    public User findUserById(int id);

}
