package cn.qdgxy.mybatis.po;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Integer oid;

    private Double total;

    private String name;

    private String phone;

    private String address;

    private Date otime;

    private Byte state;

    private Integer uid;

    private static final long serialVersionUID = 1L;

    public Order(Integer oid, Double total, String name, String phone, String address, Date otime, Byte state, Integer uid) {
        this.oid = oid;
        this.total = total;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.otime = otime;
        this.state = state;
        this.uid = uid;
    }

    public Order() {
        super();
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}