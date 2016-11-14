package cn.qdgxy.sss.mapper;

import cn.qdgxy.sss.po.UserCustom;

/**
 * 自定义用户接口
 * create:2016-11-14 20:45
 *
 * @author 李欣
 * @version 1.0
 */
public interface UserCustomMapper {

    /**
     * 按用户名查找用户
     *
     * @param username 用户名
     * @return 用户
     * @throws Exception 异常
     */
    UserCustom findUserByUsername(String username) throws Exception;

}
