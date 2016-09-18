package cn.qdgxy.bookstore.user.service;

import cn.qdgxy.bookstore.user.dao.UserDao;
import cn.qdgxy.bookstore.user.domain.User;
import cn.qdgxy.bookstore.user.domain.UserException;

/**
 * User业务层
 * 
 * @author li119
 *
 */
public class UserService {

	private UserDao userDao = new UserDao();

	/**
	 * 注册功能
	 * 
	 * @param form
	 * @throws UserException
	 */
	public void regist(User form) throws UserException {
		// 校验用户名
		User user = userDao.findByUsername(form.getUsername());
		if (user != null) {
			throw new UserException("用户已被注册！");
		}

		// 校验Email
		user = userDao.findByEmail(form.getEmail());
		if (user != null) {
			throw new UserException("Email被注册！");
		}

		// 插入用户到数据库中
		userDao.add(form);
	}

	/**
	 * 激活功能
	 * 
	 * @param code
	 * @throws UserException
	 */
	public void active(String code) throws UserException {
		// 1. 使用code查询数据库
		User user = userDao.findByCode(code);
		// 2. 判断激活码是否有效
		if (user == null) {
			throw new UserException("激活码无效！");
		}
		// 3. 校验用户是否激活
		if (user.isState()) {
			throw new UserException("您已激活， 请不要重复激活！");
		}
		// 4. 修改用户状态
		userDao.updateState(user.getUid(), true);
	}

	/**
	 * 登录功能
	 * 
	 * @param form
	 * @return
	 * @throws UserException
	 */
	public User login(User form) throws UserException {
		User user = userDao.findByUsername(form.getUsername());
		if (user == null) {
			throw new UserException("用户不存在！");
		}
		if (!user.getPassword().equals(form.getPassword())) {
			throw new UserException("密码错误！");
		}
		if (!user.isState()) {
			throw new UserException("尚未激活！");
		}
		return user;
	}

	/**
	 * 按用户名查找
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	/**
	 * 按Email查找
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @throws UserException
	 */
	public void update(User form) throws UserException {
		User user = userDao.findByUid(form.getUid());
		// 是否存在相同的用户名
		if (!user.getUsername().equals(form.getUsername())) {
			User u = userDao.findByUsername(form.getUsername());
			if (u != null) {
				throw new UserException("用户名已存在！");
			}
		}
		// 是否存在相同的邮箱
		if (!user.getEmail().equals(form.getEmail())) {
			User u = userDao.findByEmail(form.getEmail());
			if (u != null) {
				throw new UserException("邮箱已存在！");
			}
		}

		userDao.update(form);
	}

}
