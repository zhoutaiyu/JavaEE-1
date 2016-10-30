package cn.qdgxy.ssm.po;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {

    private Integer cid;

    private String cname;

    private Date ctime;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public Category(Integer cid, String cname, Date ctime, Byte isDel) {
        this.cid = cid;
        this.cname = cname;
        this.ctime = ctime;
        this.isDel = isDel;
    }

    public Category() {
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

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}