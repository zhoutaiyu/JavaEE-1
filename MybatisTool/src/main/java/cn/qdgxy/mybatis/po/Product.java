package cn.qdgxy.mybatis.po;

import java.util.Date;

public class Product {
    private Integer pid;

    private String name;

    private Float price;

    private String pic;

    private Date createTime;

    private String detail;

    public Product(Integer pid, String name, Float price, String pic, Date createTime, String detail) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.createTime = createTime;
        this.detail = detail;
    }

    public Product() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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