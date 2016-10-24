package cn.qdgxy.mybatis.po;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private Integer odid;

    private Integer ordersId;

    private Integer productId;

    private Integer productNum;

    private static final long serialVersionUID = 1L;

    public OrderDetail(Integer odid, Integer ordersId, Integer productId, Integer productNum) {
        this.odid = odid;
        this.ordersId = ordersId;
        this.productId = productId;
        this.productNum = productNum;
    }

    public OrderDetail() {
        super();
    }

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }
}