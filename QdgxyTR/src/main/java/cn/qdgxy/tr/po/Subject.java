package cn.qdgxy.tr.po;

import java.io.Serializable;
import java.util.Date;

public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer sid;
    private String sname;
    private String description;
    private Date createTime;
    private Boolean isDel;

    public Subject(Integer sid, String sname, String description, Date createTime, Boolean isDel) {
        this.sid = sid;
        this.sname = sname;
        this.description = description;
        this.createTime = createTime;
        this.isDel = isDel;
    }

    public Subject() {
        super();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}