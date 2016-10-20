package cn.qdgxy.mybatis.po;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    private Integer id;
    private Integer ordersId;
    private Integer productId;
    private Integer productNum;

    // 商品信息
    private Product product;

    public OrderDetail() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", productId=" + productId +
                ", productNum=" + productNum +
                ", product=" + product +
                '}';
    }

}