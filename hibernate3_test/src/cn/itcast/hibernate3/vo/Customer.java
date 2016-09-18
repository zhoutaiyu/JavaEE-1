package cn.itcast.hibernate3.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cid;
	private Integer version;
	private String cname;
	private Integer age;
	private Set<?> orderses = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(Integer version) {
		this.version = version;
	}

	/** full constructor */
	public Customer(Integer version, String cname, Integer age, Set<?> orderses) {
		this.version = version;
		this.cname = cname;
		this.age = age;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<?> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<?> orderses) {
		this.orderses = orderses;
	}

}