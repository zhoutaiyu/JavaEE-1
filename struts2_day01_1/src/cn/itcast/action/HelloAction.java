package cn.itcast.action;

import cn.itcast.bean.User;
import cn.itcast.filter.MyModelDriven;

public class HelloAction implements MyModelDriven<User> {

	private User user = new User();

	public String say() {
		System.out.println(user);
		return "good";
	}

	@Override
	public User getModel() {
		return user;
	}

}
