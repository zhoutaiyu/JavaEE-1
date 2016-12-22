package cn.qdgxy.shiro.mapper;

import cn.qdgxy.shiro.po.SysPermission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author liXin
 * @since 2016-12-21
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 根据用户id查询菜单
     *
     * @param userId 用户id
     * @return List<SysPermission>
     * @throws Exception Exception
     */
    List<SysPermission> findMenuListByUserId(String userId) throws Exception;

    /**
     * 根据用户id查询权限url
     *
     * @param userId 用户id
     * @return List<SysPermission>
     * @throws Exception Exception
     */
    List<SysPermission> findPermissionListByUserId(String userId) throws Exception;

}