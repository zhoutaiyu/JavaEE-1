package cn.qdgxy.bookstore.order.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.cart.domain.Cart;
import cn.qdgxy.bookstore.cart.domain.CartItem;
import cn.qdgxy.bookstore.order.domain.Order;
import cn.qdgxy.bookstore.order.domain.OrderItem;
import cn.qdgxy.bookstore.order.service.OrderException;
import cn.qdgxy.bookstore.order.service.OrderService;
import cn.qdgxy.bookstore.user.domain.User;
import cn.qdgxy.bookstore.util.page.domain.PageBean;
import cn.qdgxy.bookstore.util.page.domain.Paging;

@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderService();

	/**
	 * 添加订单
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 将session中的car生成order对象
		 */

		// 1. 从session中得到cart
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		// 2. 生成oder对象， cart --> order
		Order order = new Order();
		order.setOid(CommonUtils.uuid()); // 设置ID
		order.setOrdertime(new Date()); // 设置下单时间
		order.setState(1); // 设置下单状态，1：下单但未支付
		User user = (User) request.getSession().getAttribute("session_user");
		order.setOwner(user); // 设置订单所有者
		order.setTotal(cart.getTotal()); // 设置订单的合计

		// 创建订单条目集合，carItem --> orderItem
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem oi = new OrderItem();

			oi.setIid(CommonUtils.uuid()); // 设置条目id
			oi.setCount(cartItem.getCount()); // 设置条目的数量
			oi.setBook(cartItem.getBook()); // 设置条目的图书
			oi.setOrder(order); // 设置所属订单
			oi.setSubtotal(cartItem.getSubtotal()); // 设置条目小计
			orderItemList.add(oi);
		}

		// 将所有订单条目添加到订单中
		order.setOrderItemList(orderItemList);

		// 清空购物车
		cart.clear();

		// 3. 添加订单
		orderService.add(order);

		// 4. 转发
		request.setAttribute("order", orderService.load(order.getOid()));
		return "f:/jsps/order/pay.jsp";
	}

	/**
	 * 我的订单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String myOrders(HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("session_user");

		// 1. 获取页面传递的页码
		int pageNumber = Paging.getPageNumber(request);

		// 2. 得到PageBean
		PageBean<Order> pb = orderService.myOrders(user.getUid(), pageNumber,
				Paging.pageSize);
		// 设置URL
		pb.setUrl(Paging.getUrl(request));

		request.setAttribute("pb", pb);
		return "f:/jsps/order/list.jsp";
	}

	/**
	 * 加载订单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String load(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("order",
				orderService.load(request.getParameter("oid")));
		return "f:/jsps/order/desc.jsp";
	}

	/**
	 * 确认收货
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String confirm(HttpServletRequest request,
			HttpServletResponse response) {
		String oid = request.getParameter("oid");
		request.setAttribute("msg", "恭喜,交易成功！");
		try {
			orderService.confirm(oid);
		} catch (OrderException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/msg.jsp";
	}

	/**
	 * 支付前的加载订单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String prePay(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("order",
				orderService.load(request.getParameter("oid")));
		return "f:/jsps/order/pay.jsp";
	}

	/**
	 * 支付
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public String pay(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String oid = request.getParameter("oid");
		// Order order = orderService.load(oid);

		Properties props = new Properties();
		InputStream stream = this.getClass().getClassLoader()
				.getResourceAsStream("merchantInfo.properties");
		props.load(stream);

		// 准备13参数
		String p0_Cmd = "Buy"; // 业务类型
		String p1_MerId = props.getProperty("p1_MerId"); // 商户编号
		String p2_Order = request.getParameter(oid); // 商户订单号
		// String p3_Amt = order.getTotal() + ""; // 支付金额
		String p3_Amt = "0.01"; // 支付金额
		String p4_Cur = "CNY"; // 交易币种
		String p5_Pid = ""; // 商品名称
		String p6_Pcat = ""; // 商品种类
		String p7_Pdesc = ""; // 商品描述
		String p8_Url = props.getProperty("p8_Url");// 回调地址
		p8_Url = MessageFormat.format(p8_Url, request.getRequestURL()
				.toString());
		String p9_SAF = ""; // 送货地址
		String pa_MP = ""; // 商户扩展信息
		String pd_FrpId = request.getParameter("pd_FrpId"); // 银行编码
		String pr_NeedResponse = "1"; // 应答机制

		// 计算hmac
		String keyValue = props.getProperty("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);

		// 连接易宝网址和13+1参数
		StringBuilder url = new StringBuilder(props.getProperty("url"));
		url.append("?p0_Cmd=").append(p0_Cmd);
		url.append("&p1_MerId=").append(p1_MerId);
		url.append("&p2_Order=").append(p2_Order);
		url.append("&p3_Amt=").append(p3_Amt);
		url.append("&p4_Cur=").append(p4_Cur);
		url.append("&p5_Pid=").append(p5_Pid);
		url.append("&p6_Pcat=").append(p6_Pcat);
		url.append("&p7_Pdesc=").append(p7_Pdesc);
		url.append("&p8_Url=").append(p8_Url);
		url.append("&p9_SAF=").append(p9_SAF);
		url.append("&pa_MP=").append(pa_MP);
		url.append("&pd_FrpId=").append(pd_FrpId);
		url.append("&pr_NeedResponse=").append(pr_NeedResponse);
		url.append("&hmac=").append(hmac);

		// 重定向到易宝
		response.sendRedirect(url.toString());
		return null;
	}

	/**
	 * 易宝回调方法
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public String back(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 1. 获取11+1参数
		String p1_MerId = request.getParameter("p1_MerId"); // 商户编号
		String r0_Cmd = request.getParameter("r0_Cmd"); // 业务类型
		String r1_Code = request.getParameter("r1_Code"); // 支付结果
		String r2_TrxId = request.getParameter("r2_TrxId"); // 易宝支付交易流水号
		String r3_Amt = request.getParameter("r3_Amt"); // 支付金额
		String r4_Cur = request.getParameter("r4_Cur"); // 交易币种
		String r5_Pid = request.getParameter("r5_Pid"); // 商品名称
		String r6_Order = request.getParameter("r6_Order"); // 商户订单号
		String r7_Uid = request.getParameter("r7_Uid"); // 易宝支付会员ID
		String r8_MP = request.getParameter("r8_MP"); // 商户扩展信息
		String r9_BType = request.getParameter("r9_BType"); // 交易结果返回类型

		String hmac = request.getParameter("hmac");

		// 2. 校验访问者是否为易宝
		Properties props = new Properties();
		InputStream stream = this.getClass().getClassLoader()
				.getResourceAsStream("merchantInfo.properties");
		props.load(stream);
		String keyValue = props.getProperty("keyValue");

		boolean bool = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
				r8_MP, r9_BType, keyValue);

		// 校验失败
		if (!bool) {
			request.setAttribute("msg", "YOUR ARE LOSER!");
			return "f:/jsps/msg.jsp";
		}

		// 3. 校验成功，修改订单状态，添加积分等业务（无）
		orderService.pay(r6_Order);

		// 4. 判断易宝回到方式
		if (r9_BType.equals("2")) {
			// 点对点回调，需要回复success
			response.getWriter().print("success");
		}

		// 5. 支付成功
		request.setAttribute("msg", "支付成功！");
		return "f:jsps/msg.jsp";
	}

}
