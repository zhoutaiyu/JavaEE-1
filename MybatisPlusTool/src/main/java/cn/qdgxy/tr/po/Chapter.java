package cn.qdgxy.tr.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 章节
 * </p>
 *
 * @author liXin
 * @since 2016-12-15
 */
public class Chapter extends Model<Chapter> {

    private static final long serialVersionUID = 1L;

    /**
     * 章节id
     */
    private Long id;
    /**
     * 章节名称
     */
    private String cname;
    /**
     * 章节描述
     */
    private String description;
    /**
     * 章节教程链接
     */
    @TableField(value = "teach_link")
    private String teachLink;
    /**
     * 创建时间
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
    /**
     * 科目id
     */
    private Long sid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeachLink() {
        return teachLink;
    }

    public void setTeachLink(String teachLink) {
        this.teachLink = teachLink;
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

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
