package cn.qdgxy.shop.product.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.qdgxy.shop.category.service.CategoryService;
import cn.qdgxy.shop.category.vo.Category;
import cn.qdgxy.shop.product.service.ProductService;
import cn.qdgxy.shop.product.vo.Product;
import cn.qdgxy.shop.utils.page.PagingUtils;
import cn.qdgxy.shop.utils.page.vo.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {

	private static final long serialVersionUID = 1L;
	private Product product = new Product();
	@Resource(name = "categoryService")
	private CategoryService categoryService;
	@Resource(name = "productService")
	private ProductService productService;

	private Integer cid; // 一级分类ID
	private Integer csid; // 二级分类ID
	private Integer pageNumber; // 当前页码

	private PageBean<Product> pageBean; // 分页商品

	/**
	 * 按照一级分类查找商品
	 * 
	 * @return
	 */
	public String findbyCategory() {
		// 查询分类：查询所有一级分类
		passCategory();

		// 查询商品
		pageBean = productService.findByCategory(cid,
				PagingUtils.getPageNumber(pageNumber));

		// 设置URL
		pageBean.setUrl(PagingUtils.getUrl(ServletActionContext.getRequest()));

		return "findbyCategory_sussess";
	}

	/**
	 * 按照二级分类查找商品
	 * 
	 * @return
	 */
	public String findByCategorySecond() {
		// 查询分类：查询所有一级分类
		passCategory();

		// 查询商品
		pageBean = productService.findByCategorySecond(csid,
				PagingUtils.getPageNumber(pageNumber));

		// 设置URL
		pageBean.setUrl(PagingUtils.getUrl(ServletActionContext.getRequest()));

		return "findbyCategorySecond_sussess";
	}

	/**
	 * 加载商品详情
	 * 
	 * @return
	 */
	public String load() {
		// 查询分类：查询所有一级分类
		passCategory();

		product = productService.findById(product.getPid());

		return "load_sussess";
	}

	/**
	 * 给页面传递一级分类
	 */
	private void passCategory() {
		List<Category> categoryList = categoryService.findAll();
		ActionContext.getContext().getValueStack()
				.set("categoryList", categoryList);
	}

	@Override
	public Product getModel() {
		return product;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public PageBean<Product> getPageBean() {
		return pageBean;
	}

}
