package cn.itcast.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action处理请求参数
 * 
 * 第一种 ：Action 本身作为model对象，通过成员setter封装 （属性驱动 ）
 * 
 * @author 李欣
 *
 */
public class Login1Action extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("zhangsan".equals(username) && "123456".equals(password)) {
			request.getSession().setAttribute("username", username);
			return SUCCESS;
		} else {
			request.setAttribute("login.message", "用户名或密码错误");
			return LOGIN;
		}
	}

}
