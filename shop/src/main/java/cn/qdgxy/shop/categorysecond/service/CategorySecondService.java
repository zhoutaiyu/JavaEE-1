package cn.qdgxy.shop.categorysecond.service;

import cn.qdgxy.shop.categorysecond.dao.CategorySecondDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class CategorySecondService {

	@Resource
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

}
