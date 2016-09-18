package cn.qdgxy.bookstore.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.qdgxy.bookstore.admin.domain.Admin;

public class AdminDao {

	/**
	 * 按用户名查找
	 * 
	 * @param username
	 * @return
	 */
	public Admin findByUsername(String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "SELECT * FROM admin WHERE username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				admin = new Admin();
				admin.setAid(rs.getString("aid"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBConnection.closeDBConnection(conn, pstmt, rs);
		}
		return admin;
	}

	/**
	 * 插入管理员
	 * 
	 * @param admin
	 */
	public void add(Admin admin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getDBConnection();
			String sql = "INSERT INTO admin VALUE(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getAid());
			pstmt.setString(2, admin.getUsername());
			pstmt.setString(3, admin.getPassword());
			pstmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBConnection.closeDBConnection(conn, pstmt);
		}

	}
	
	

}
