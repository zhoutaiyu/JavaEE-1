package cn.qdgxy.bookstore.cart.domain;

import java.math.BigDecimal;

import cn.qdgxy.bookstore.book.domain.Book;

/**
 * 购物车条目类
 * 
 * @author li119
 *
 */
public class CartItem {

	private Book book; // 商品
	private int count; // 数量

	public CartItem() {
		super();
	}

	/**
	 * 小计（处理了二进制运算误差问题）
	 * 
	 * @return
	 */
	public double getSubtotal() {
		BigDecimal d1 = new BigDecimal(this.book.getPrice() + "");
		BigDecimal d2 = new BigDecimal(this.count + "");
		return d1.multiply(d2).doubleValue();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + "]";
	}

}
