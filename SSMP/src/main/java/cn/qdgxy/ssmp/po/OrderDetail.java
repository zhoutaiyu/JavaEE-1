package cn.qdgxy.ssmp.po;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer ordersId;
    private Integer productId;
    private Integer productNum;

    public OrderDetail(Integer id, Integer ordersId, Integer productId, Integer productNum) {
        this.id = id;
        this.ordersId = ordersId;
        this.productId = productId;
        this.productNum = productNum;
    }

    public OrderDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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