package cn.qdgxy.shop.categorysecond.action;

import cn.qdgxy.shop.categorysecond.service.CategorySecondService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class CategorySecondAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

}
