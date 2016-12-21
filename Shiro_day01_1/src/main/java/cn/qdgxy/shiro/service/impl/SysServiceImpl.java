package cn.qdgxy.shiro.service.impl;

import cn.qdgxy.shiro.exception.MyException;
import cn.qdgxy.shiro.mapper.SysUserMapper;
import cn.qdgxy.shiro.po.ActiveUser;
import cn.qdgxy.shiro.po.SysPermission;
import cn.qdgxy.shiro.po.SysUser;
import cn.qdgxy.shiro.service.SysService;
import cn.qdgxy.shiro.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 认证授权服务实现
 *
 * @author 李欣
 * @version 1.0
 * @since 2016-12-21 16:49
 */
@Service
@Transactional
public class SysServiceImpl implements SysService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
     *
     * @param userCode 账号
     * @param password 密码
     * @return ActiveUser
     * @throws Exception Exception
     */
    @Override
    public ActiveUser authenticat(String userCode, String password) throws Exception {
        //认证过程：
        //根据用户身份（账号）查询数据库，如果查询不到用户不存在
        //对输入的密码 和数据库密码 进行比对，如果一致，认证通过

        //根据用户账号查询数据库
        SysUser sysUser = this.findSysUserByUserCode(userCode);

        if (sysUser == null) {
            //抛出异常
            throw new MyException("用户账号不存在");
        }

        //数据库密码 (md5密码 )
        String password_db = sysUser.getPassword();

        // 对输入的密码 和数据库密码 进行比对，如果一致，认证通过
        // 对页面输入的密码 进行md5加密
        String password_input_md5 = new MD5().getMD5ofStr(password);
        if (!password_input_md5.equalsIgnoreCase(password_db)) {
            //抛出异常
            throw new MyException("用户名或密码错误");
        }

        //得到用户id
        Long userid = sysUser.getId();
        //根据用户id查询菜单
        List<SysPermission> menus = this.findMenuListByUserId(userid);

        //根据用户id查询权限url
        List<SysPermission> permissions = this.findPermissionListByUserId(userid);

        //认证通过，返回用户身份信息
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserId(sysUser.getId());
        activeUser.setUserCode(userCode);
        activeUser.setUsername(sysUser.getUsername());//用户名称

        //放入权限范围的菜单和url
        activeUser.setMenus(menus);
        activeUser.setPermissions(permissions);

        return activeUser;
    }

    /**
     * 根据用户账号查询用户信息
     *
     * @param userCode 账号
     * @return SysUser
     * @throws Exception Exception
     */
    @Override
    public SysUser findSysUserByUserCode(String userCode) throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setUserCode(userCode);

        return sysUserMapper.selectOne(sysUser);
    }

    /**
     * @param userId ID
     * @return List<SysPermission>
     * @throws Exception Exception
     */
    @Override
    public List<SysPermission> findMenuListByUserId(Long userId) throws Exception {
        return null;
    }

    /**
     * 根据用户id查询权限范围的url
     *
     * @param userId ID
     * @return List<SysPermission>
     * @throws Exception Exception
     */
    @Override
    public List<SysPermission> findPermissionListByUserId(Long userId) throws Exception {
        return null;
    }

}
