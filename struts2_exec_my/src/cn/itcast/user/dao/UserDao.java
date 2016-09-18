package cn.itcast.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.user.domain.User;
import cn.itcast.user.exception.MySQLException;

public class UserDao {

	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @throws MySQLException
	 */
	public void add(User user) throws MySQLException {
		try {
			String sql = "INSERT INTO `s_user` VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Object[] params = { user.getUserName(), user.getLoginName(),
					user.getLoginPwd(), user.getSex(), user.getBirthday(),
					user.getEducation(), user.getTelephone(),
					user.getInterest(), user.getPath(), user.getFilename(),
					user.getRemark() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new MySQLException(e);
		}
	}

	/**
	 * 删除
	 * 
	 * @param userID
	 * @throws MySQLException
	 */
	public void delete(Integer userID) throws MySQLException {
		String sql = "DELETE FROM `s_user` WHERE userID=?";
		try {
			qr.update(sql, userID);
		} catch (SQLException e) {
			throw new MySQLException(e);
		}
	}

	/**
	 * 修改
	 * 
	 * @param user
	 * @throws MySQLException
	 */
	public void edit(User user, boolean isEditUpload) throws MySQLException {
		try {
			if (isEditUpload) {
				String sql = "UPDATE `s_user` SET `userName`=? , `loginName`=? "
						+ " , `loginPwd`=? , `sex`=? , `birthday`=? , `education`=? "
						+ " , `telephone`=? , `interest`=? , `path`=? , `fileName`=? "
						+ " , `remark`=? WHERE `userId`=?";
				Object[] params = { user.getUserName(), user.getLoginName(),
						user.getLoginPwd(), user.getSex(), user.getBirthday(),
						user.getEducation(), user.getTelephone(),
						user.getInterest(), user.getPath(), user.getFilename(),
						user.getRemark(), user.getUserID() };

				qr.update(sql, params);

			} else {
				String sql = "UPDATE `s_user` SET `userName`=? , `loginName`=? "
						+ " , `loginPwd`=? , `sex`=? , `birthday`=? , `education`=? "
						+ " , `telephone`=? , `interest`=? , `remark`=? WHERE `userId`=?";
				Object[] params = { user.getUserName(), user.getLoginName(),
						user.getLoginPwd(), user.getSex(), user.getBirthday(),
						user.getEducation(), user.getTelephone(),
						user.getInterest(), user.getRemark(), user.getUserID() };
				qr.update(sql, params);
			}
		} catch (SQLException e) {
			throw new MySQLException(e);
		}
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws MySQLException
	 */
	public List<User> findAll() throws MySQLException {
		try {
			String sql = "SELECT * FROM `s_user`";
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			throw new MySQLException(e);
		}
	}

	/**
	 * 按ID查询用户
	 * 
	 * @param userID
	 * @return
	 * @throws MySQLException
	 */
	public User findById(Integer userID) throws MySQLException {
		try {
			String sql = "SELECT * FROM `s_user` WHERE `userID`=?";
			return qr.query(sql, new BeanHandler<User>(User.class), userID);
		} catch (SQLException e) {
			throw new MySQLException(e);
		}
	}

	/**
	 * 按登录名查找
	 * 
	 * @param loginName
	 * @return
	 * @throws MySQLException
	 */
	public User findByLoginName(String loginName) throws MySQLException {
		try {
			String sql = "SELECT * FROM `s_user` WHERE `loginName`=?";
			return qr.query(sql, new BeanHandler<User>(User.class), loginName);
		} catch (SQLException e) {
			throw new MySQLException(e);
		}
	}

	/**
	 * 条件查询
	 * 
	 * @param user
	 * @return
	 * @throws MySQLException
	 */
	public List<User> findBySelect(User user) throws MySQLException {
		try {
			StringBuilder sql = new StringBuilder(
					"SELECT * FROM `s_user` WHERE 1=1 ");
			List<Object> params = new ArrayList<Object>();

			String userName = user.getUserName();
			if (userName != null && !userName.trim().isEmpty()) {
				sql.append(" AND `userName` LIKE ? ");
				params.add("%" + userName + "%");
			}

			String sex = user.getSex();
			if (sex != null && !sex.trim().isEmpty()) {
				sql.append(" AND `sex`=? ");
				params.add(sex);
			}

			String education = user.getEducation();
			if (education != null && !education.trim().isEmpty()) {
				sql.append(" AND `education`=? ");
				params.add(education);
			}

			String isUpload = user.getIsUpload();
			if ("1".equals(isUpload)) {
				sql.append(" AND `filename` IS NOT NULL ");
			} else if ("0".equals(isUpload)) {
				sql.append(" AND `filename` IS NULL ");
			}

			return qr.query(sql.toString(), new BeanListHandler<User>(
					User.class), params.toArray());
		} catch (SQLException e) {
			throw new MySQLException(e);
		}
	}

}
