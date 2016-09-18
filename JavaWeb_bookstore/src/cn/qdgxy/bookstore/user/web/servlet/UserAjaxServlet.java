package cn.qdgxy.bookstore.user.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.user.domain.User;
import cn.qdgxy.bookstore.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ajax校验
 * 
 * @author li119
 *
 */
@WebServlet("/UserAjaxServlet")
public class UserAjaxServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	/**
	 * 用户名是否存在验证
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkUsername(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		String username = request.getParameter("username");
		User user = userService.findByUsername(username);
		if (user != null) {
			writer.print(true);
		} else {
			writer.print(false);
		}
	}

	/**
	 * 邮箱是否存在验证
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkEmail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		String email = request.getParameter("email");
		User user = userService.findByEmail(email);
		if (user != null) {
			writer.print(true);
		} else {
			writer.print(false);
		}
	}

}
