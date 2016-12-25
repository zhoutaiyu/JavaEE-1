package cn.qdgxy.shiro.shiro;

import cn.qdgxy.shiro.po.ActiveUser;
import cn.qdgxy.shiro.po.SysPermission;
import cn.qdgxy.shiro.po.SysUser;
import cn.qdgxy.shiro.service.SysService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 自定义realm
 */
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private SysService sysService;

    // 设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    // 用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        // token是用户输入的
        // 第一步从token中取出身份信息 账号
        String userCode = (String) token.getPrincipal();

        /// 第二步：根据用户输入的userCode从数据库查询
        SysUser sysUser = null;
        try {
            sysUser = sysService.findSysUserByUserCode(userCode);
        } catch (Exception ignored) {
        }

        // 如果查询不到返回null
        if (sysUser == null) {
            return null;
        }

        // 从数据库查询到密码
        String password = sysUser.getPassword();

        //盐
        String salt = sysUser.getSalt();


        // 如果查询到返回认证信息AuthenticationInfo

        //activeUser就是用户身份信息
        ActiveUser activeUser = new ActiveUser();

        activeUser.setUserId(sysUser.getId());
        activeUser.setUserCode(sysUser.getUserCode());
        activeUser.setUsername(sysUser.getUsername());
        //..

        //根据用户id取出菜单
        List<SysPermission> menus = null;
        try {
            //通过service取出菜单
            menus = sysService.findMenuListByUserId(sysUser.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将用户菜单 设置到activeUser
        activeUser.setMenus(menus);


        //将activeUser设置simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                activeUser, password, ByteSource.Util.bytes(salt), this.getName());

        return simpleAuthenticationInfo;
    }

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        //从 principals获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
        ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();

        //根据身份信息获取权限信息
        //连接数据库...
        //模拟从数据库获取到数据
        List<String> permissions = new ArrayList<>();
        permissions.add("user:create");//用户的创建
        permissions.add("items:add");//商品添加权限
        permissions.add("product:query");//商品添加权限
        //....

        //查到权限数据，返回授权信息(要包括上边的permissions)
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

}
