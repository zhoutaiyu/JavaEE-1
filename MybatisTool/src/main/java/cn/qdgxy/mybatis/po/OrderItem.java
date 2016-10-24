package cn.qdgxy.mybatis.po;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private Integer oiid;

    private Integer count;

    private Double subtotal;

    private Integer pid;

    private Integer oid;

    private static final long serialVersionUID = 1L;

    public OrderItem(Integer oiid, Integer count, Double subtotal, Integer pid, Integer oid) {
        this.oiid = oiid;
        this.count = count;
        this.subtotal = subtotal;
        this.pid = pid;
        this.oid = oid;
    }

    public OrderItem() {
        super();
    }

    public Integer getOiid() {
        return oiid;
    }

    public void setOiid(Integer oiid) {
        this.oiid = oiid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}