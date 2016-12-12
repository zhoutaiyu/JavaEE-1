package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable {

    private Long id;

    private String cname;

    private String description;

    private String teachLink;

    private Date createTime;

    private Date modifiedTime;

    private Boolean isDel;

    private Long sid;

    private static final long serialVersionUID = 1L;

    public Chapter(Long id, String cname, String description, String teachLink, Date createTime, Date modifiedTime, Boolean isDel, Long sid) {
        this.id = id;
        this.cname = cname;
        this.description = description;
        this.teachLink = teachLink;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.isDel = isDel;
        this.sid = sid;
    }

    public Chapter() {
        super();
    }

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
        this.cname = cname == null ? null : cname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTeachLink() {
        return teachLink;
    }

    public void setTeachLink(String teachLink) {
        this.teachLink = teachLink == null ? null : teachLink.trim();
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

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
}