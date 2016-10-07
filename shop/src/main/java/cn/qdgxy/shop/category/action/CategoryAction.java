package cn.qdgxy.shop.category.action;

import cn.qdgxy.shop.category.service.CategoryService;
import cn.qdgxy.shop.category.vo.Category;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class CategoryAction extends ActionSupport implements
        ModelDriven<Category> {

    private static final long serialVersionUID = 1L;
    private Category category = new Category();
    @Resource
    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category getModel() {
        return category;
    }

}
