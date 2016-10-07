package cn.qdgxy.shop.index.action;

import cn.qdgxy.shop.category.service.CategoryService;
import cn.qdgxy.shop.category.vo.Category;
import cn.qdgxy.shop.product.service.ProductService;
import cn.qdgxy.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页访问
 *
 * @author 李欣
 */
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Resource
    private CategoryService categoryService; // 一级分类
    @Resource
    private ProductService productService; // 商品

    private List<Product> hotList; // 热门商品
    private List<Product> newList; // 最新商品

    @Override
    public String execute() throws Exception {
        // 查找所有一级分类
        List<Category> categoryList = categoryService.findAll();
        // 存入Session
        ActionContext.getContext().getSession()
                .put("categoryList", categoryList);

        // 查询热门商品
        hotList = productService.findHot();

        // 查询最新商品
        newList = productService.findNew();

        return "index_success";
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getHotList() {
        return hotList;
    }

    public List<Product> getNewList() {
        return newList;
    }

}
