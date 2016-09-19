package cn.qdgxy.form.service;

import cn.qdgxy.form.dao.ProductDao;
import cn.qdgxy.form.domain.Product;
import cn.qdgxy.util.page.domain.PageBean;

public class ProductService {

	private ProductDao productDao = new ProductDao();

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
		return productDao.findAll(pageNumber, pageSize);
	}

	/**
	 * 添加
	 * 
	 * @param product
	 */
	public void add(Product product) {
		productDao.add(product);
	}

	/**
	 * 删除（实际未删除）
	 * 
	 * @param pid
	 */
	public void delete(Integer pid) {
		productDao.delete(pid);
	}

	/**
	 * 修改
	 * 
	 * @param product
	 */
	public void edit(Product product) {
		productDao.edit(product);
	}

}
