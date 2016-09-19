package cn.qdgxy.form.dao;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
import cn.qdgxy.form.domain.Product;
import cn.qdgxy.util.page.dao.PagingDao;
import cn.qdgxy.util.page.domain.PageBean;

public class ProductDao {

	private QueryRunner qr = new TxQueryRunner();
	private PagingDao<Product> pagingDao = new PagingDao<Product>();

	/**
	 * 查找所有
	 * 
	 * @param pageNumber
	 *            当前页码
	 * @param pageSize
	 *            显示数量
	 * @return
	 */
	public PageBean<Product> findAll(int pageNumber, int pageSize) {
		String totalRecordSql = "SELECT COUNT(*) FROM `product` WHERE `del`=0";
		String beanListSql = "SELECT * FROM `product` WHERE `del`=0 LIMIT ?, ?";
		return pagingDao.findAll(qr, pageNumber, pageSize, totalRecordSql, beanListSql, Product.class);
	}

	/**
	 * 添加
	 * 
	 * @param product
	 */
	public void add(Product product) {
		String sql = "INSERT INTO `product`(name, price) VALUES(?, ?)";
		Object[] params = { product.getName(), product.getPrice() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除（实际未删除）
	 * 
	 * @param pid
	 */
	public void delete(Integer pid) {
		String sql = "UPDATE `product` SET `del`=1 WHERE `pid`=?";
		try {
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改
	 * 
	 * @param product
	 */
	public void edit(Product product) {
		String sql = "UPDATE `product` SET name=?, price=? WHERE pid=?";
		Object[] params = { product.getName(), product.getPrice(), product.getPid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
