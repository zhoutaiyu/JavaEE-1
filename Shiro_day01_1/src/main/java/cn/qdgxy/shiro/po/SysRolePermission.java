package cn.qdgxy.shiro.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author liXin
 * @since 2016-12-21
 */
@TableName("sys_role_permission")
public class SysRolePermission extends Model<SysRolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;
    /**
     * 角色id
     */
    @TableField(value = "sys_role_id")
    private String sysRoleId;
    /**
     * 权限id
     */
    @TableField(value = "sys_permission_id")
    private String sysPermissionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public String getSysPermissionId() {
        return sysPermissionId;
    }

    public void setSysPermissionId(String sysPermissionId) {
        this.sysPermissionId = sysPermissionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
