package cn.itcast.action;

import cn.itcast.domin.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 使用模型驱动
 * 
 * @author 李欣
 *
 */
public class RegistAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	@Override
	public String execute() throws Exception {

		System.out.println(user);
		return NONE;
	}

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void validate() {
		if (user.getUsername() == null
				|| user.getUsername().trim().length() == 0) {
			this.addFieldError("username.message", "用户名不能为空");
		}

		if (user.getPassword() == null
				|| user.getPassword().trim().length() == 0) {
			this.addFieldError("password.message", "密码不能为空");
		}

		if (!(user.getAge() >= 10 && user.getAge() <= 40)) {
			this.addFieldError("age.message", "年龄必须在10-40之间");
		}
	}

}
