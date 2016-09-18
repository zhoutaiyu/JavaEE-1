package cn.qdgxy.shop.cart.vo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车类
 * 
 * @author 李欣
 *
 */
public class Cart {

	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>(); // 商品ID，商品条目

	/**
	 * 添加图书条目
	 * 
	 * @param cartItem
	 */
	public void add(CartItem cartItem) {
		// 存在商品增加数量， 不存在向购物车添加商品
		// 判断原来购物车中是否存在该图书条目
		if (map.containsKey(cartItem.getProduct().getPid())) {
			CartItem _cartItem = map.get(cartItem.getProduct().getPid());
			// 设置老条目的数量 = 其自己数量 + 新条目的数量
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
		} else {
			map.put(cartItem.getProduct().getPid(), cartItem);
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
	 * @param pid
	 */
	public void delete(Integer pid) {
		map.remove(pid);
	}

	/**
	 * 获取所有商品条目
	 * 
	 * @return
	 */
	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	/**
	 * 合计（商品条目总价格）
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
	 * 获得商品数量
	 * 
	 * @return
	 */
	public int getProductNumber() {
		int productNumber = 0;
		for (Integer key : map.keySet()) {
			CartItem cartItem = map.get(key);
			productNumber += cartItem.getCount();
		}
		return productNumber;
	}

}
