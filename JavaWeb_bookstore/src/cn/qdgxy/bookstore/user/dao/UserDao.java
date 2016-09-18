package cn.qdgxy.bookstore.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.qdgxy.bookstore.user.domain.User;

/**
 * User持久层
 * 
 * @author li119
 *
 */
public class UserDao {

	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 按用户名查询
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		String sql = "SELECT * FROM tb_user WHERE username=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按email查询
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		String sql = "SELECT * FROM tb_user WHERE email=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按uid查询
	 * 
	 * @param username
	 * @return
	 */
	public User findByUid(String uid) {
		String sql = "SELECT * FROM tb_user WHERE uid=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), uid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 插入User
	 * 
	 * @param user
	 * @return
	 */
	public void add(User user) {
		String sql = "INSERT INTO tb_user VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = { user.getUid(), user.getUsername(),
				user.getPassword(), user.getEmail(), user.getConsignee(),
				user.getPhone(), user.getAdress(), user.getCode(),
				user.isState() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按激活码查询
	 * 
	 * @param code
	 * @return
	 */
	public User findByCode(String code) {
		String sql = "SELECT * FROM tb_user WHERE code=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), code);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改指定用户的指定状态
	 * 
	 * @param code
	 * @return
	 */
	public void updateState(String uid, boolean state) {
		String sql = "UPDATE tb_user SET state=? WHERE uid=?";
		try {
			qr.update(sql, state, uid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改用户信息
	 * 
	 * @param code
	 * @return
	 */
	public void update(User user) {
		String sql = "UPDATE `tb_user` SET `username`=?, `password`=?, "
				+ " `email`=?, `consignee`=?, `phone`=?, `adress`=? WHERE `uid`=?";
		Object[] params = { user.getUsername(), user.getPassword(),
				user.getEmail(), user.getConsignee(), user.getPhone(),
				user.getAdress(), user.getUid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
