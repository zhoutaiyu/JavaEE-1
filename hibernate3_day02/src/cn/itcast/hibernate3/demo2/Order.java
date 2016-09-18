package cn.itcast.hibernate3.demo2;

/**
 * 订单的实体
 * 
 * @author 李欣
 *
 */
public class Order {

	private Integer oid;
	private String address;
	private Customer customer; // 订单属于某一个客户

	public Order() {
		super();
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", address=" + address + ", customer="
				+ customer + "]";
	}

}
