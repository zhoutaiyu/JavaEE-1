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
public class _RegistAction extends ActionSupport implements ModelDriven<User> {

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

}
