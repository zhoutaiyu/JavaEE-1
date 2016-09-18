package cn.qdgxy.bookstore.category.service;

import java.util.List;

import cn.qdgxy.bookstore.book.dao.BookDao;
import cn.qdgxy.bookstore.category.dao.CategoryDao;
import cn.qdgxy.bookstore.category.domain.Category;
import cn.qdgxy.bookstore.category.web.servlet.admin.CategoryException;

public class CategoryService {

	private CategoryDao categoryDao = new CategoryDao();
	private BookDao bookDao = new BookDao();

	/**
	 * 查找所有分类
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	/**
	 * 添加分类
	 * 
	 * @param form
	 */
	public void add(Category form) {
		categoryDao.add(form);
	}

	/**
	 * 删除分类
	 * 
	 * @param cid
	 * @throws CategoryException
	 */
	public void delete(String cid) throws CategoryException {
		int count = bookDao.getCountByCid(cid);
		// 该分类下存在图书，抛出异常
		if (count > 0) {
			throw new CategoryException("该分类下存在图书，不能删除！");
		}
		// 该分类下的图书为0才进行删除
		categoryDao.delete(cid);
	}

	/**
	 * 加载分类
	 * 
	 * @param cid
	 * @return
	 */
	public Category load(String cid) {
		return categoryDao.load(cid);
	}

	/**
	 * 修改分类
	 * 
	 * @param form
	 */
	public void edit(Category form) {
		categoryDao.edit(form);
	}

}
