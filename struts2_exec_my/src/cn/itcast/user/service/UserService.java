package cn.itcast.user.service;

import java.util.List;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;
import cn.itcast.user.exception.MySQLException;

public class UserService {

	private UserDao userDao = new UserDao();

	/**
	 * 登录
	 * 
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public User login(String loginName) throws MySQLException {
		return userDao.findByLoginName(loginName);
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(User user) throws MySQLException {
		userDao.add(user);
	}

	/**
	 * 删除
	 * 
	 * @param userID
	 */
	public void delete(Integer userID) throws MySQLException {
		userDao.delete(userID);
	}

	/**
	 * 修改
	 * 
	 * @param user
	 */
	public void edit(User user, boolean isEditUpload) throws MySQLException {
		userDao.edit(user, isEditUpload);
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<User> findAll() throws MySQLException {
		return userDao.findAll();
	}

	/**
	 * 按ID查询用户
	 * 
	 * @param userID
	 * @return
	 */
	public User findById(Integer userID) throws MySQLException {
		return userDao.findById(userID);
	}

	/**
	 * 条件查询
	 * 
	 * @param user
	 * @return
	 */
	public List<User> findBySelect(User user) throws MySQLException {
		return userDao.findBySelect(user);
	}

}
