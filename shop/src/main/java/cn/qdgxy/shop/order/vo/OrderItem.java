package cn.qdgxy.shop.order.vo;

import cn.qdgxy.shop.product.vo.Product;

import java.io.Serializable;

/**
 * 订单项
 *
 * @author 李欣
 */
public class OrderItem implements Serializable {

    private Integer oiid; // 订单项ID
    private Integer count;// 商品数量
    private Double subtotal; // 商品小计

    private Product product; // 商品
    private Order order; // 所属订单

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem [oiid=" + oiid + ", count=" + count + ", subtotal=" + subtotal + "]";
    }

}
