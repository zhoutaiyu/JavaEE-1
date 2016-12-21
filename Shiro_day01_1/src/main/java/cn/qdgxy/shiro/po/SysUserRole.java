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
@TableName("sys_user_role")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;
    /**
     *
     */
    @TableField(value = "sys_user_id")
    private String sysUserId;
    /**
     *
     */
    @TableField(value = "sys_role_id")
    private String sysRoleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
