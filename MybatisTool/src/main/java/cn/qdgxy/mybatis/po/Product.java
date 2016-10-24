package cn.qdgxy.mybatis.po;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer odid;

    private String name;

    private Float price;

    private String pic;

    private Date createTime;

    private String detail;

    private static final long serialVersionUID = 1L;

    public Product(Integer odid, String name, Float price, String pic, Date createTime, String detail) {
        this.odid = odid;
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.createTime = createTime;
        this.detail = detail;
    }

    public Product() {
        super();
    }

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}