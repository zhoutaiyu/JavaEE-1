package cn.qdgxy.shop.categorysecond.service;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import cn.qdgxy.shop.categorysecond.dao.CategorySecondDao;

@Transactional
public class CategorySecondService {

	@Resource(name = "categorySecondDao")
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

}
