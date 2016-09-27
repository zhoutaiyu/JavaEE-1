package cn.qdgxy.shop.categorysecond.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import cn.qdgxy.shop.categorysecond.service.CategorySecondService;

public class CategorySecondAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource(name = "categorySecondService")
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

}
