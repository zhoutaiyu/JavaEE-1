package cn.qdgxy.sss.dao;

import cn.qdgxy.sss.po.UserCustom;

/**
 * 用户Dao接口
 * create:2016-11-13 20:55
 *
 * @author 李欣
 * @version 1.0
 */
public interface UserDao {

    /**
     * 按用户名查找用户
     *
     * @param userName 用户名
     * @return 用户
     */
    UserCustom findByUsername(String userName) throws Exception;

}
