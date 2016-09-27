package cn.qdgxy.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.qdgxy.shop.category.vo.Category;

public class CategoryDao extends HibernateDaoSupport {

	/**
	 * 查询所有一级分类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		return (List<Category>) this.getHibernateTemplate().find(
				"from Category where is_del=0");
	}

}
