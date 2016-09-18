package cn.qdgxy.bookstore.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.qdgxy.bookstore.category.domain.Category;

public class CategoryDao {

	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 查询所有分类
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAll() {
		String sql = "SELECT * FROM category ORDER BY cname";
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加分类
	 * 
	 * @param form
	 */
	public void add(Category form) {
		String sql = "INSERT INTO category VALUES(?, ?)";
		try {
			qr.update(sql, form.getCid(), form.getCname());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除分类
	 * 
	 * @param cid
	 */
	public void delete(String cid) {
		String sql = "DELETE FROM category WHERE cid=?";
		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载分类
	 * 
	 * @param cid
	 * @return
	 */
	public Category load(String cid) {
		String sql = "SELECT * FROM category WHERE cid=?";
		try {
			return qr
					.query(sql, new BeanHandler<Category>(Category.class), cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改分类
	 * 
	 * @param form
	 */
	public void edit(Category form) {
		String sql = "UPDATE category SET cname=? WHERE cid=?";
		try {
			qr.update(sql, form.getCname(), form.getCid());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
