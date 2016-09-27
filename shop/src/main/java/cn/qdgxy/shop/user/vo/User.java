package cn.qdgxy.shop.user.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.qdgxy.shop.order.vo.Order;

/**
 * 用户
 * 
 * @author 李欣
 *
 */
public class User {

	private Integer uid; // 用户ID
	private String username; // 登录名
	private String password; // 登录密码
	private String name; // 用户名
	private String email; // 邮箱
	private String phone; // 手机号
	private String address; // 地址
	private String sex; // 性别
	private Integer state; // 用户状态：0未激活 1已激活
	private String code; // 激活码
	private Date utime; // 用户创建时间

	private Set<Order> orders = new HashSet<Order>(); // 订单

	public User() {
		super();
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", sex=" + sex + ", state=" + state + ", code=" + code + ", usertime=" + utime + "]";
	}

}
