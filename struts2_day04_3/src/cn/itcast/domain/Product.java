package cn.itcast.domain;

import org.apache.struts2.json.annotations.JSON;

public class Product {

	private int id;
	private String name;
	private Double price;
	private int count;

	public Product() {
		super();
	}

	public Product(int id, String name, Double price, int count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
	}

	@JSON(serialize = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", count=" + count + "]";
	}

}
