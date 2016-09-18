package cn.qdgxy.bookstore.category.web.servlet;

import java.io.IOException;
import java.util.List;

import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.category.domain.Category;
import cn.qdgxy.bookstore.category.service.CategoryService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

@WebServlet("/CategoryAjaxServlet")
public class CategoryAjaxServlet extends BaseServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = new CategoryService();

	/**
	 * 查询所有分类
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> catagoryList = categoryService.findAll();
		JSONArray array = JSONArray.fromObject(catagoryList);	// 转化成json数字
		response.getWriter().write(array.toString());
		return null;
	}
}
