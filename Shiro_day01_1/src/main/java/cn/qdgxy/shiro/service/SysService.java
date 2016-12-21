package cn.qdgxy.shiro.service;

import cn.qdgxy.shiro.po.ActiveUser;
import cn.qdgxy.shiro.po.SysPermission;
import cn.qdgxy.shiro.po.SysUser;

import java.util.List;

/**
 * 认证授权服务接口
 *
 * @author 李欣
 * @version 1.0
 * @since 2016-12-21 16:49
 */
public interface SysService {

    /**
     * 根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
     *
     * @param userCode 账号
     * @param password 密码
     * @return ActiveUser
     * @throws Exception Exception
     */
    ActiveUser authenticat(String userCode, String password) throws Exception;

    /**
     * 根据用户账号查询用户信息
     *
     * @param userCode 账号
     * @return SysUser
     * @throws Exception Exception
     */
    SysUser findSysUserByUserCode(String userCode) throws Exception;

    /**
     * @param userId ID
     * @return List<SysPermission>
     * @throws Exception Exception
     */
    List<SysPermission> findMenuListByUserId(Long userId) throws Exception;

    /**
     * 根据用户id查询权限范围的url
     *
     * @param userId ID
     * @return List<SysPermission>
     * @throws Exception Exception
     */
    List<SysPermission> findPermissionListByUserId(Long userId) throws Exception;

}
