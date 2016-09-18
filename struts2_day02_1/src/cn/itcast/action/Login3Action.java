package cn.itcast.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domin.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Action处理请求参数
 * 
 * 第三种 ：使用ModelDriven接口，对请求数据进行封装 （模型驱动 ） ----- 主流
 * 
 * @author 李欣
 *
 */
public class Login3Action extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private User user = new User();

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

	@Override
	public User getModel() {
		return user;
	}

}
