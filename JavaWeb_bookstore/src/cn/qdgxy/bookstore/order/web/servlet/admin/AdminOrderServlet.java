package cn.qdgxy.bookstore.order.web.servlet.admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.order.domain.Order;
import cn.qdgxy.bookstore.order.service.OrderService;
import cn.qdgxy.bookstore.util.page.domain.PageBean;
import cn.qdgxy.bookstore.util.page.domain.Paging;

@WebServlet("/admin/AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderService();

	/**
	 * 查询所有订单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAll(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. 获取页面传递的页码
		int pageNumber = Paging.getPageNumber(request);

		// 2. 得到PageBean
		PageBean<Order> pb = orderService.findAll(pageNumber, Paging.pageSize);
		// 设置URL
		pb.setUrl(Paging.getUrl(request));

		request.setAttribute("pb", pb);
		return "f:/adminjsps/admin/order/list.jsp";
	}

	/**
	 * 按订单状态查询订单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String findByState(HttpServletRequest request,
			HttpServletResponse response) {
		String state = request.getParameter("state");

		// 1. 获取页面传递的页码
		int pageNumber = Paging.getPageNumber(request);

		// 2. 得到PageBean
		PageBean<Order> pb = orderService.findByState(state, pageNumber,
				Paging.pageSize);
		// 设置URL
		pb.setUrl(Paging.getUrl(request));

		request.setAttribute("pb", pb);
		return "f:/adminjsps/admin/order/list.jsp";
	}

	/**
	 * 发货
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String ship(HttpServletRequest request, HttpServletResponse response) {
		orderService.ship(request.getParameter("oid"));
		return "f:/admin/AdminOrderServlet?method=findByState&state=2";
	}

}
