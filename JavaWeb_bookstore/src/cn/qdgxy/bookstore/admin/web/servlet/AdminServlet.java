package cn.qdgxy.bookstore.admin.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.admin.domain.Admin;
import cn.qdgxy.bookstore.admin.domain.AdminException;
import cn.qdgxy.bookstore.admin.service.AdminService;

@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService();

	/**
	 * 管理员登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Admin adm = new Admin();
		adm.setUsername(request.getParameter("username"));
		adm.setPassword(request.getParameter("password"));
		
		// 校验输入信息
		Map<String, String> errors = AdmValidation.ValidateLogin(adm, request);
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("adm", adm);
			return "f:/adminjsps/login/login.jsp";
		}

		try {
			Admin admin = adminService.login(adm);
			request.getSession().setAttribute("session_admin", admin);
			return "f:/adminjsps/admin/index.jsp";
		} catch (AdminException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("adm", adm);
			return "f:/adminjsps/login/login.jsp";
		}

	}
	
	/**
	 * 退出
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String quit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/adminjsps/login/login.jsp";
	}

}
