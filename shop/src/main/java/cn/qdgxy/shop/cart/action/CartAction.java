package cn.qdgxy.shop.cart.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.qdgxy.shop.cart.vo.Cart;
import cn.qdgxy.shop.cart.vo.CartItem;
import cn.qdgxy.shop.product.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource(name = "productService")
	private ProductService productService;

	private Integer pid; // 商品ID
	private Integer count; // 商品数量

	/**
	 * 跳转至购物车页面
	 * 
	 * @return
	 */
	public String cartPage() {
		return "cartPage";
	}

	/**
	 * 添加商品至购物车
	 * 
	 * @return
	 */
	public String add() {
		// 创建商品条目
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(productService.findById(pid));

		// 添加至购物车
		Cart cart = getCart(ServletActionContext.getRequest());
		cart.add(cartItem);

		return "cartPage";
	}

	/**
	 * 清空购物车
	 * 
	 * @return
	 */
	public String clear() {
		Cart cart = getCart(ServletActionContext.getRequest());
		cart.clear();
		return "cartPage";
	}

	/**
	 * 删除商品
	 * 
	 * @return
	 */
	public String delete() {
		Cart cart = getCart(ServletActionContext.getRequest());
		cart.delete(pid);
		return "cartPage";
	}

	/**
	 * 获得购物车
	 * 
	 * @param request
	 * @return
	 */
	private Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}

		return cart;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
