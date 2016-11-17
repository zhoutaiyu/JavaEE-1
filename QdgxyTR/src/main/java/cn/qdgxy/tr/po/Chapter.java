package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer cid;
    private String cname;
    private String description;
    private String teachLink;
    private Date createTime;
    private Boolean isDel;
    private Integer sid;

    public Chapter(Integer cid, String cname, String description, String teachLink, Date createTime, Boolean isDel, Integer sid) {
        this.cid = cid;
        this.cname = cname;
        this.description = description;
        this.teachLink = teachLink;
        this.createTime = createTime;
        this.isDel = isDel;
        this.sid = sid;
    }

    public Chapter() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}