package cn.qdgxy.shiro.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author liXin
 * @since 2016-12-21
 */
@TableName("order_detail")
public class OrderDetail extends Model<OrderDetail> {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 订单id
     */
    @TableField(value = "orders_id")
    private Integer ordersId;
    /**
     * 商品id
     */
    @TableField(value = "product_id")
    private Integer productId;
    /**
     * 商品购买数量
     */
    @TableField(value = "product_num")
    private Integer productNum;


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

    @Override
    protected Serializable pkVal() {
        return this.id;
	}

}
