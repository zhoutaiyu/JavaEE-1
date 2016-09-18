package cn.qdgxy.bookstore.cart.web.servlet;

import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.cart.domain.Cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartAjaxServlet")
public class CartAjaxServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 获得购物车信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getCarMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int bookNumber = 0; // 购物车中的图书的数量
		double totalMoney = 0; // 购物车中的图书金额

		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart != null) {
			bookNumber = cart.getBookNumber();
			totalMoney = cart.getTotal();
		}

		String msg = "{bookNumber:" + bookNumber + ", totalMoney:" + totalMoney
				+ "}";
		response.getWriter().print(msg);
		return null;
	}

}
