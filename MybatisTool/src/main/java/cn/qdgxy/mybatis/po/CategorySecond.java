package cn.qdgxy.mybatis.po;

import java.io.Serializable;
import java.util.Date;

public class CategorySecond implements Serializable {
    private Integer csid;

    private String csname;

    private Date cstime;

    private Integer cid;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public CategorySecond(Integer csid, String csname, Date cstime, Integer cid, Byte isDel) {
        this.csid = csid;
        this.csname = csname;
        this.cstime = cstime;
        this.cid = cid;
        this.isDel = isDel;
    }

    public CategorySecond() {
        super();
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname == null ? null : csname.trim();
    }

    public Date getCstime() {
        return cstime;
    }

    public void setCstime(Date cstime) {
        this.cstime = cstime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}