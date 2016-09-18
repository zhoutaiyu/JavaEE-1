package cn.qdgxy.bookstore.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.cart.domain.Cart;
import cn.qdgxy.bookstore.user.domain.User;
import cn.qdgxy.bookstore.user.domain.UserException;
import cn.qdgxy.bookstore.user.service.UserService;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User表述层
 * 
 * @author li119
 *
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);

		// 校验输入信息
		Map<String, String> errors = UserValidation.checkLogin(form, request);
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}

		try {
			User user = userService.login(form);
			request.getSession().setAttribute("session_user", user);
			// 添加购物车
			request.getSession().setAttribute("cart", new Cart());

			return "f:/jsps/user_online/user.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}
	}

	/**
	 * 注册功能
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String regist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 封装表单数据
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);

		// 2. 补全uuid、验证信息
		form.setUid(CommonUtils.uuid());
		form.setCode(CommonUtils.uuid() + CommonUtils.uuid());

		// 3. 检验信息
		Map<String, String> errors = UserValidation.checkRegister(form, request);
		// 判断是否存在错误信息
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
		}

		// 4. 调用service完成注册
		try {
			userService.regist(form);
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
		}

		// 5. 发邮件
		this.sendEmail(form.getEmail(), form.getCode(), request.getRequestURL()
				.toString());

		request.setAttribute("msg", "恭喜，注册成功！请马上到邮箱激活!");
		return "f:/jsps/frame/msg.jsp";
	}

	/**
	 * 激活功能
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String active(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		try {
			userService.active(code);
			request.setAttribute("msg", "恭喜您激活成功，请登录！");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/frame/msg.jsp";
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
		return "r:/index.jsp";
	}

	/**
	 * 修改用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);

		// 检验信息
		Map<String, String> errors = UserValidation.checkUpdate(form, request);
		// 判断是否存在错误信息
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user_online/user.jsp";
		}

		try {
			userService.update(form);
			request.setAttribute("msg", "修改成功，请重新登陆");
			request.getSession().invalidate();
			return "f:/jsps/user/login.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/jsps/user_online/user.jsp";
		}

	}

	/**
	 * 发送邮件
	 * 
	 * @param to
	 *            收件人
	 * @param code
	 *            激活码
	 * @param url
	 *            点击链接的参数前部分
	 * @throws IOException
	 */
	private void sendEmail(String to, String code, String url)
			throws IOException {
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader()
				.getResourceAsStream("email_template.properties"));
		String host = props.getProperty("host");
		String uname = props.getProperty("uname");
		String pwd = props.getProperty("pwd");
		String from = props.getProperty("from");
		String subject = props.getProperty("subject");
		String content = props.getProperty("content");
		content = MessageFormat.format(content, url, code);

		Session session = MailUtils.createSession(host, uname, pwd);
		Mail mail = new Mail(from, to, subject, content);
		try {
			MailUtils.send(session, mail); // 发邮件
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
