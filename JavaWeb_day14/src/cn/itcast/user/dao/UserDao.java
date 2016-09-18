package cn.itcast.user.dao;

import cn.itcast.user.domain.User;

/**
 * UserDao接口
 * @author li119
 *
 */
public interface UserDao {
	
	public User findByUsername(String username);
	public void add(User user);

}
