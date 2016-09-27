package cn.qdgxy.shop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import cn.qdgxy.shop.product.dao.ProductDao;
import cn.qdgxy.shop.product.vo.Product;
import cn.qdgxy.shop.utils.page.vo.PageBean;

@Transactional
public class ProductService {

	@Resource(name = "productDao")
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * 查找热门商品
	 * 
	 * @return
	 */
	public List<Product> findHot() {
		return productDao.findHot();
	}

	/**
	 * 查找最新商品
	 * 
	 * @return
	 */
	public List<Product> findNew() {
		return productDao.findNew();
	}

	/**
	 * 按一级分类查找商品
	 * 
	 * @param cid
	 * @param pageNumber
	 * @return
	 */
	public PageBean<Product> findByCategory(Integer cid, int pageNumber) {
		final int PAGESIZE = 12; // 每页记录数

		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPageNumber(pageNumber);
		pageBean.setPageSize(PAGESIZE);

		// 查询一级分类总商品数
		Integer totalRecord = productDao.findCountByCategory(cid);
		pageBean.setTotalRecord(totalRecord);

		// 查询一级分类商品
		List<Product> productList = productDao.findByCategory(cid, pageNumber,
				PAGESIZE);
		pageBean.setBeanList(productList);

		return pageBean;
	}

	/**
	 * 按二级分类查找商品
	 * 
	 * @param csid
	 * @param pageNumber
	 * @return
	 */
	public PageBean<Product> findByCategorySecond(Integer csid, int pageNumber) {
		final int PAGESIZE = 8; // 每页记录数

		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPageNumber(pageNumber);
		pageBean.setPageSize(PAGESIZE);

		// 查询二级分类总商品数
		Integer totalRecord = productDao.findCountByCategorySecond(csid);
		pageBean.setTotalRecord(totalRecord);

		// 查询二级分类商品
		List<Product> productList = productDao.findByCategorySecond(csid,
				pageNumber, PAGESIZE);
		pageBean.setBeanList(productList);

		return pageBean;
	}

	/**
	 * 加载商品详情
	 * 
	 * @param pid
	 * @return
	 */
	public Product findById(Integer pid) {
		return productDao.findById(pid);
	}

}
