package cn.qdgxy.shop.order.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.qdgxy.shop.user.vo.User;

/**
 * 订单
 * 
 * @author 李欣
 *
 */
public class Order {

	private Integer oid; // 订单ID
	private Double total; // 总计
	private String name; // 姓名
	private String phone; // 手机号
	private String address; // 地址
	private Date otime; // 订单时间
	private Integer state; // 订单状态： 1. 未付款， 2. 已付款未发货， 3. 已发货未确认收货， 4. 已确认交易成功

	private User user; // 所属用户
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(); // 包含订单项

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
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOtime() {
		return otime;
	}

	public void setOtime(Date otime) {
		this.otime = otime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", name=" + name + ", phone=" + phone + ", address=" + address + ", otime=" + otime + ", state=" + state + "]";
	}

}
