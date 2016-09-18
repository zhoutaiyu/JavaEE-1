package cn.itcast.spring3.demo2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDao extends JdbcDaoSupport {

	/**
	 * 添加
	 * 
	 * @param user
	 */
	public void add(User user) {
		String sql = "insert into `user` values (null,?)";
		this.getJdbcTemplate().update(sql, user.getName());
	}

	/**
	 * 修改
	 * 
	 * @param user
	 */
	public void update(User user) {
		String sql = "update user set name = ? where id = ?";
		this.getJdbcTemplate().update(sql, user.getName(), user.getId());
	}

	/**
	 * 删除
	 * 
	 * @param user
	 */
	public void delete(User user) {
		String sql = "delete from user where id = ?";
		this.getJdbcTemplate().update(sql, user.getId());
	}

	/**
	 * 查询数量
	 * 
	 * @return
	 */
	public int findCount() {
		String sql = "select count(*) from user";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	/**
	 * 通过ID查询名字
	 * 
	 * @param id
	 * @return
	 */
	public String findNameById(int id) {
		String sql = "select name from user where id = ?";
		return this.getJdbcTemplate().queryForObject(sql, String.class, id);
	}

	/**
	 * 通过ID查询用户
	 * 
	 * @param id
	 * @return
	 */
	public User findById(int id) {
		String sql = "select * from user where id = ?";
		User user = this.getJdbcTemplate().queryForObject(sql,
				new UserRowMapper(), id);
		return user;
	}

	/**
	 * 查询多个用户
	 * 
	 * @return
	 */
	public List<User> findAll() {
		String sql = "select * from user";
		return this.getJdbcTemplate().query(sql, new UserRowMapper());
	}

	/**
	 * 需要自己实现封装
	 * 
	 * @author 李欣
	 *
	 */
	class UserRowMapper implements RowMapper<User> {

		/**
		 * rs:结果集. rowNum:行号
		 */
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));

			return user;
		}

	}
}
