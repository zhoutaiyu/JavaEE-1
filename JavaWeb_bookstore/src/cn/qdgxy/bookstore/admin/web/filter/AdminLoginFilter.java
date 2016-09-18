package cn.qdgxy.bookstore.admin.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import cn.qdgxy.bookstore.admin.domain.Admin;

/**
 * 拦截未登录的管理员
 * 
 * @author qq477
 *
 */
@WebFilter(urlPatterns = { "/adminjsps/admin/*", "/admin/*" })
public class AdminLoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Admin admin = (Admin) httpRequest.getSession().getAttribute(
				"session_admin");
		if (admin != null) {
			chain.doFilter(request, response);
		} else {
			httpRequest.setAttribute("msg", "您还没有登录！");
			httpRequest.getRequestDispatcher("/adminjsps/login/login.jsp")
					.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
