package cn.qdgxy.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import cn.qdgxy.shop.user.vo.User;

public class UserDao extends HibernateDaoSupport {

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 */
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	/**
	 * 按用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User findByUsername(String username) {
		List<User> users = (List<User>) this.getHibernateTemplate().find(
				"from User where username=?", username);

		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * 按Email查找用户
	 * 
	 * @param email
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User findByEmail(String email) {
		List<User> users = (List<User>) this.getHibernateTemplate().find(
				"from User where email=?", email);

		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * 按照激活码查询用户
	 * 
	 * @param code
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User findByCode(String code) {
		List<User> users = (List<User>) this.getHibernateTemplate().find(
				"from User where code=?", code);

		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

}
