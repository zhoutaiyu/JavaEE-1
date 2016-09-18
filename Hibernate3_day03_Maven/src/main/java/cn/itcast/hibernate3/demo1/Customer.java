package cn.itcast.hibernate3.demo1;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户的实体:
 * @author 姜涛
 *
 */
public class Customer {
	private Integer cid;
	private String cname;
	private Integer age;
	// 乐观锁解决丢失更新,提供一个整数类型的属性.
	private Integer ver;
	public Customer() {
	}
	
	
	public Customer(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}


	// 一个客户有多个订单.
	private Set<Order> orders = new HashSet<Order>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getVer() {
		return ver;
	}
	public void setVer(Integer ver) {
		this.ver = ver;
	}


	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", age=" + age
				+ ", ver=" + ver + "]";
	}

}
