package cn.itcast.user.service;

import cn.itcast.user.dao.DaoFactory;
import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

/**
 * User业务逻辑层
 * 
 * @author li119
 *
 */
public class UserService {

	// 把具体实现类的创建隐藏到工厂之中
	private UserDao userDao = DaoFactory.getUserDao();
	
	/**
	 * 注册功能
	 * @param user
	 * @throws UserException
	 */
	public void regist(User user) throws UserException {
		/**
		 * 1. 使用用户名去查询，如果返回null，完成添加
		 * 2. 如果返回的不是null，抛出异常！
		 */
		
		String username = user.getUsername();
		User _user = userDao.findByUsername(username);
		if (_user != null) {
			throw new UserException("用户名" + username + "已被注册！");
		}
		userDao.add(user);
	}

	/**
	 * 登录功能
	 * @param form
	 * @return
	 * @throws UserException 
	 */
	public User login(User form) throws UserException {
		/*
		 * 1. 使用form中的username进行查询。得到User user
		 */
		User user = userDao.findByUsername(form.getUsername());
		/*
		 * 2.如果返回null，说明用户名不存在，抛出异常，异常信息为用户名不存在！
		 */
		if (user == null) {
			throw new UserException("用户名不存在！");
		}
		/*
		 * 3. 比较user的password和form的password，如果不同，抛出异常，异常信息为密码错误！
		 */
		if (!user.getPassword().equals(form.getPassword())) {
			throw new UserException("密码错误！");
		}
		
		return user;
	}

}
