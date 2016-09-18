package test.dao;

import org.junit.Test;

import cn.itcast.user.dao.UserDaoXmlImpl;
import cn.itcast.user.domain.User;

public class UserDaoTest {

	@Test
	public void testFindByUsername() throws Exception {

	}

	@Test
	public void testAdd() throws Exception {
		UserDaoXmlImpl userDao = new UserDaoXmlImpl();
		User user = new User();
		user.setUsername("lsii ");
		user.setPassword("1234");
		userDao.add(user);
	}

}
