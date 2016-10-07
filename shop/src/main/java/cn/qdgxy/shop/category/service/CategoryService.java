package cn.qdgxy.shop.category.service;

import cn.qdgxy.shop.category.dao.CategoryDao;
import cn.qdgxy.shop.category.vo.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class CategoryService {

    @Resource
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
