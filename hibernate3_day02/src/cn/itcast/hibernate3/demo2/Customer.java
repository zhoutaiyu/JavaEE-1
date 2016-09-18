package cn.itcast.hibernate3.demo2;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户实体
 * 
 * @author 李欣
 *
 */
public class Customer {

	private Integer cid;
	private String cname;
	private Set<Order> orders = new HashSet<Order>(); // 一个客户有多个订单

	public Customer() {
		super();
	}

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

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", orders="
				+ orders + "]";
	}

}
