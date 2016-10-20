package cn.qdgxy.mybatis.po_extend;

import cn.qdgxy.mybatis.po.Orders;

/**
 * 订单扩展对象 用来完成订单和用户查询结果的映射<br>
 * create:2016-10-18 20:10
 *
 * @author 李欣
 * @versin 1.0
 */
public class OrderCustom extends Orders {

    // 补充用户信息
    private String username;
    private String sex;
    private String address;

    public OrderCustom() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderCustom{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}
