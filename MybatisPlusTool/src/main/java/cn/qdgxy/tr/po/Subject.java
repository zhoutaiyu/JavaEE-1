package cn.qdgxy.tr.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 科目表
 * </p>
 *
 * @author liXin
 * @since 2016-12-15
 */
public class Subject extends Model<Subject> {

    private static final long serialVersionUID = 1L;

    /**
     * 科目id
     */
    private Long id;
    /**
     * 科目名称
     */
    private String sname;
    /**
     * 科目描述
     */
    private String description;
    /**
     * 添加时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     *
     */
    @TableField(value = "modified_time")
    private Date modifiedTime;
    /**
     * 是否删除
     */
    @TableField(value = "is_del")
    private Integer isDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
