package cn.qdgxy.mybatis.mapper;

import cn.qdgxy.mybatis.po.User;
import cn.qdgxy.mybatis.po_extend.UserQueryVo;

import java.util.List;

/**
 * 用户Dao
 * create:2016-10-16 17:43
 *
 * @author 李欣
 * @version 1.0
 */
public interface UserMapper {

    //根据id查询用户信息
    User findUserById(int id) throws Exception;

    //根据用户名称模糊查询用户列表
    List<User> findUserByName(String username) throws Exception;

    //自定义查询条件查询用户信息
    List<User> findUserList(UserQueryVo userQueryVo) throws Exception;

    //自定义查询条件查询用户数量
    int findUserCount(UserQueryVo userQueryVo) throws Exception;

    // 查询用户 使用resultMap
    List<User> findUserListResultMap(UserQueryVo userQueryVo) throws Exception;

    // 插入用户
    int insertUser(User user) throws Exception;

    // 删除用户
    void deleteUser(int id) throws Exception;

    // 修改用户
    void updateUser(User user) throws Exception;

}
