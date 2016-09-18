package cn.qdgxy.bookstore.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车类
 * 
 * @author li119
 *
 */
public class Cart {

	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();

	/**
	 * 添加图书条目
	 * 
	 * @param cartItem
	 */
	public void add(CartItem cartItem) {
		// 存在商品增加数量， 不存在向购物车添加商品
		// 判断原来购物车中是否存在该图书条目
		if (map.containsKey(cartItem.getBook().getBid())) {
			CartItem _cartItem = map.get(cartItem.getBook().getBid());
			// 设置老条目的数量 = 其自己数量 + 新条目的数量
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
			map.put(cartItem.getBook().getBid(), _cartItem);
		} else {
			map.put(cartItem.getBook().getBid(), cartItem);
		}
	}

	/**
	 * 清空购物车
	 */
	public void clear() {
		map.clear();
	}

	/**
	 * 删除指定图书条目
	 * 
	 * @param bid
	 */
	public void delete(String bid) {
		map.remove(bid);
	}

	/**
	 * 获取所有图书条目
	 * 
	 * @return
	 */
	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	/**
	 * 合计（图书条目总价格）
	 * 
	 * @return
	 */
	public double getTotal() {
		// 合计 = 所有条目的小计之和
		BigDecimal total = new BigDecimal("0");
		for (CartItem cartItem : map.values()) {
			BigDecimal subtotal = new BigDecimal(cartItem.getSubtotal() + "");
			total = total.add(subtotal);
		}
		return total.doubleValue();
	}

	/**
	 * 获得图书数量
	 * 
	 * @return
	 */
	public int getBookNumber() {
		int bookNumber = 0;
		for (String key : map.keySet()) {
			CartItem cartItem = map.get(key);
			bookNumber += cartItem.getCount();
		}
		return bookNumber;
	}

}
