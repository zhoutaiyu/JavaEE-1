package cn.itcast.action;

import java.util.List;

import cn.itcast.domin.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 封装数据到List
 * 
 * @author 李欣
 *
 */
public class ListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<User> users;

	@Override
	public String execute() throws Exception {
		for (User user : users) {
			System.out.println(user);
		}
		return NONE;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
