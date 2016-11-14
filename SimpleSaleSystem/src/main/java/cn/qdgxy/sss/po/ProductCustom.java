package cn.qdgxy.sss.po;

/**
 * 自定义商品
 * create:2016-11-12 20:28
 *
 * @author 李欣
 * @version 1.0
 */
public class ProductCustom extends Product {

    private Integer oid; // 订单ID
    private double buyPrice;  // 购买价格
    private String buyTime; // 购买时间

    /**
     * 是否购买
     *
     * @return 是否购买
     */
    public boolean getIsBuy() {
        return oid != null;
    }

    /**
     * 是否已经卖出
     *
     * @return 是否已经卖出
     */
    public boolean getIsSell() {
        return oid != null;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }
}
