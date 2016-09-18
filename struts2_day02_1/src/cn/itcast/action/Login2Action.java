package cn.itcast.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domin.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action处理请求参数
 * 
 * 第二种 ：创建独立model对象，页面通过ognl表达式封装 （属性驱动）
 * 
 * @author 李欣
 *
 */
public class Login2Action extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		String username = user.getUsername();
		String password = user.getPassword();

		if ("zhangsan".equals(username) && "123456".equals(password)) {
			request.getSession().setAttribute("username", username);
			return SUCCESS;
		} else {
			request.setAttribute("login.message", "用户名或密码错误");
			return LOGIN;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
