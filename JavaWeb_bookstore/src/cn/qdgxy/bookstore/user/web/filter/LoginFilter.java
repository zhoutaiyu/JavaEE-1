package cn.qdgxy.bookstore.user.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import cn.qdgxy.bookstore.user.domain.User;

/**
 * 拦截未登录用户使用购物车、订单
 * 
 * @author li119
 *
 */
@WebFilter(urlPatterns = { "/jsps/cart/*", "/jsps/order/*", "/jsps/user_online/*", "/CartServlet",
		"/OrderServlet" })
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		User user = (User) httpRequest.getSession()
				.getAttribute("session_user");
		if (user != null) {
			chain.doFilter(request, response);
		} else {
			httpRequest.setAttribute("msg", "您还没有登录！");
			httpRequest.getRequestDispatcher("/jsps/user/login.jsp").forward(
					request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
