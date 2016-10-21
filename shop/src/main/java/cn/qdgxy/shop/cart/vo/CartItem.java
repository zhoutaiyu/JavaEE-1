package cn.qdgxy.shop.cart.vo;

import cn.qdgxy.shop.product.vo.Product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车条目类
 *
 * @author 李欣
 */
public class CartItem implements Serializable {

    private Product product; // 商品
    private int count; // 数量

    public CartItem() {
        super();
    }

    /**
     * 小计（处理了二进制运算误差问题）
     *
     * @return
     */
    public double getSubtotal() {
        BigDecimal d1 = new BigDecimal(product.getShop_price() + "");
        BigDecimal d2 = new BigDecimal(count + "");
        return d1.multiply(d2).doubleValue();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartItem [product=" + product + ", count=" + count + "]";
    }

}
