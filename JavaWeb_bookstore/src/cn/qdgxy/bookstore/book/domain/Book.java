package cn.qdgxy.bookstore.book.domain;

import java.util.Date;

import cn.qdgxy.bookstore.category.domain.Category;

/**
 * 图书类
 * 
 * @author li119
 *
 */
public class Book {

	private String bid; // 图书id
	private String bname; // 图书姓名
	private double price; // 图书价格
	private String author; // 图书作者
	private String image; // 图书图片
	private Category category; // 图书分类
	private Date addtime; // 图书添加时间
	private boolean del; // 图书是否被删除

	public Book() {
		super();
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", price=" + price
				+ ", author=" + author + ", image=" + image + ", category="
				+ category + ", addtime=" + addtime + ", del=" + del + "]";
	}

}