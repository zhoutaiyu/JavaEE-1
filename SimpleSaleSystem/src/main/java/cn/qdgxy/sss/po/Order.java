package cn.qdgxy.sss.po;

import java.io.Serializable;

public class Order implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer uid;

    private Double buyPrice;

    private String buyTime;

    private static final long serialVersionUID = 1L;

    public Order(Integer id, Integer pid, Integer uid, Double buyPrice, String buyTime) {
        this.id = id;
        this.pid = pid;
        this.uid = uid;
        this.buyPrice = buyPrice;
        this.buyTime = buyTime;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime == null ? null : buyTime.trim();
    }
}