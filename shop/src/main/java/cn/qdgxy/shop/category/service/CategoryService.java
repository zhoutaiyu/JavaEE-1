package cn.qdgxy.shop.category.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import cn.qdgxy.shop.category.dao.CategoryDao;
import cn.qdgxy.shop.category.vo.Category;

@Transactional
public class CategoryService {

	@Resource(name = "categoryDao")
	private CategoryDao categoryDao;

	/**
	 * 查询所有一级分类
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
