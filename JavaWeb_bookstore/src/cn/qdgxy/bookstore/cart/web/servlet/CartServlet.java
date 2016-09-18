package cn.qdgxy.bookstore.cart.web.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.book.domain.Book;
import cn.qdgxy.bookstore.book.service.BookService;
import cn.qdgxy.bookstore.cart.domain.Cart;
import cn.qdgxy.bookstore.cart.domain.CartItem;
import cn.qdgxy.bookstore.util.validation.IllegalStringException;
import cn.qdgxy.bookstore.util.validation.Validation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 添加图书条目到购物车
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 得到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 2. 得到购物商品
		// 得到图书ID
		String bid = request.getParameter("bid");
		Book book = new BookService().load(bid);
		// 得到图书数量
		String strNum = request.getParameter("count");
		// 校验图书数量
		try {
			String result = Validation.checkNumber(strNum);
			if (result != null) {
				request.setAttribute("msg", result);
				return "/BookServlet?method=load&bid=" + bid;
			}
		} catch (IllegalStringException e) {
			request.setAttribute("msg", e.getMessage());
			return "/BookServlet?method=load&bid=" + bid;
		}
		int count = Integer.parseInt(request.getParameter("count"));

		CartItem cartItem = new CartItem();
		cartItem.setBook(book);
		cartItem.setCount(count);
		// 3. 将购物图书条目添加到购物车中
		cart.add(cartItem);
		return "f:/jsps/cart/list.jsp";
	}

	/**
	 * 清空购物车
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 得到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 2. 清空购物车
		cart.clear();
		return "f:/jsps/cart/list.jsp";
	}

	/**
	 * 删除商品
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 得到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 2. 删除商品
		String bid = request.getParameter("bid");
		cart.delete(bid);
		return "f:/jsps/cart/list.jsp";
	}

}
