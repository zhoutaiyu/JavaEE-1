package cn.itcast.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.user.domain.User;

/**
 * 针对mysql数据库的类
 * 
 * @author li119
 *
 */
public class UserDaoJdbcImpl implements UserDao {

	@Override
	public User findByUsername(String username) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			/*
			 * 1. 得到连接
			 */
			con = JdbcUtils.getConnection();
			/*
			 * 2. 准备sql模板 得到pstmt
			 */
			String sql = "SELECT * FROM `user` WHERE `username`=?";
			pstmt = con.prepareCall(sql);
			/*
			 * 3. 为pstmt中的问号赋值
			 */
			pstmt.setString(1, username);
			/*
			 * 4. 执行
			 */
			rs = pstmt.executeQuery();
			/*
			 * 5. 把rs转换成User类型，然后返回
			 */
			User user = null;
			if (rs.next()) {
				// 转换User
				// ORM对象关系映射
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			} 
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void add(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			/*
			 * 1. 得到连接
			 */
			con = JdbcUtils.getConnection();
			/*
			 * 2. 准备sql模板 得到pstmt
			 */
			String sql = "INSERT INTO `user` VALUES(?, ?)";
			pstmt = con.prepareCall(sql);
			/*
			 * 3. 为pstmt中的问号赋值
			 */
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			/*
			 * 4. 执行
			 */
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
