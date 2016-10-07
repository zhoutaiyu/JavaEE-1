package cn.qdgxy.shop.user.service;

import cn.qdgxy.shop.user.dao.UserDao;
import cn.qdgxy.shop.user.vo.User;
import cn.qdgxy.shop.user.vo.UserException;
import cn.qdgxy.shop.utils.mail.MailUtils;
import cn.qdgxy.shop.utils.uuid.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Date;

@Transactional
@Service
public class UserService {

	@Resource
	private UserDao userDao;

	/**
	 * 登录
	 * 
	 * @param user
	 * @throws UserException
	 */
	public User login(User user) throws UserException {
		User _user = userDao.findByUsername(user.getUsername());

		if (_user == null) {
			throw new UserException("用户不存在！");
		} else if (!_user.getPassword().equals(user.getPassword())) {
			throw new UserException("密码错误！");
		} else if (_user.getState() == 0) {
			throw new UserException("用户未激活，请至邮箱激活！");
		} else {
			return _user;
		}
	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @throws UserException
	 */
	public void regist(User user) throws UserException {
		// 1. 验证Email是否重复注册
		User _user = userDao.findByEmail(user.getEmail());

		if (_user != null) {
			throw new UserException("邮箱已注册！");
		} else {
			// 2. 保存用户
			user.setState(0); // 设置用户状态
			user.setUtime(new Date()); // 添加用户注册时间
			user.setCode(UUIDUtils.getUUID() + UUIDUtils.getUUID());// 生成激活码
			userDao.save(user);

			// 3. 发送邮件
			try {
				MailUtils.sendMail(user.getEmail(), user.getCode());
			} catch (MessagingException e) {
				throw new UserException("邮件发送错误！");
			}
		}
	}

	/**
	 * 激活
	 * 
	 * @param code
	 * @throws UserException
	 */
	public void active(String code) throws UserException {
		// 查询用户是否存在
		User _user = userDao.findByCode(code);

		if (_user != null) {
			// 激活用户
			if (_user.getState() == 0) {
				_user.setState(1);
				userDao.update(_user);
			} else {
				throw new UserException("请不要重复激活！");
			}
		} else {
			throw new UserException("激活失败！");
		}
	}

	/**
	 * 按用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
