package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class Subject implements Serializable {

    private Long id;

    private String sname;

    private String description;

    private Date createTime;

    private Date modifiedTime;

    private Boolean isDel;

    private static final long serialVersionUID = 1L;

    public Subject(Long id, String sname, String description, Date createTime, Date modifiedTime, Boolean isDel) {
        this.id = id;
        this.sname = sname;
        this.description = description;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.isDel = isDel;
    }

    public Subject() {
        super();
    }

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
        this.sname = sname == null ? null : sname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}