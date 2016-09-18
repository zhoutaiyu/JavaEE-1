package cn.itcast.test;

import org.junit.Test;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

public class TestUserDao {

	private UserDao userDao = new UserDao();

	/**
	 * 测试添加用户
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		User user = new User();
		user.setUserName("lisisi");
		userDao.add(user);
	}

}
