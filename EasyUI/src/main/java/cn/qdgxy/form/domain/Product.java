package cn.qdgxy.form.domain;

/**
 * 商品
 * 
 * @author 李欣
 *
 */
public class Product {

	private Integer pid; // ID
	private String name; // 名称
	private Double price; // 价格

	public Product() {
		super();
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}

}
