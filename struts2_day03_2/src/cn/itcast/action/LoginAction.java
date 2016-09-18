package cn.itcast.action;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	@Override
	public String execute() throws Exception {
		if ("zhangsan".equals(user.getUsername())
				&& "123456".equals(user.getPassword())) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", user);
			return SUCCESS;
		} else {
			this.addActionError("用户名或密码错误");
			return INPUT;
		}
	}

	@Override
	public User getModel() {
		return user;
	}

}
