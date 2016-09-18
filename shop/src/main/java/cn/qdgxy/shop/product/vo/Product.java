package cn.qdgxy.shop.product.vo;

import java.util.Date;

import cn.qdgxy.shop.categorysecond.vo.CategorySecond;

/**
 * 产品
 * 
 * @author 李欣
 *
 */
public class Product {

	private Integer pid; // 产品ID
	private String pname; // 产品名称
	private Double market_price; // 市场价格
	private Double shop_price; // 商城价格
	private String image; // 图片路径
	private String pdesc; // 产品详情
	private Integer is_hot; // 是否热门
	private Date ptime; // 添加时间
	private Integer is_del; // 是否删除

	private CategorySecond categorySecond; // 所属二级分类

	public Product() {
		super();
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public Double getShop_price() {
		return shop_price;
	}

	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Integer getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	public Date getPtime() {
		return ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

	public Integer getIs_del() {
		return is_del;
	}

	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}

	public CategorySecond getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price=" + shop_price + ", image=" + image + ", pdesc=" + pdesc + ", is_hot=" + is_hot + ", ptime=" + ptime + ", is_del=" + is_del + "]";
	}

}
