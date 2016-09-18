package cn.qdgxy.bookstore.category.web.servlet;

import java.io.IOException;

import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.category.service.CategoryService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet implements Servlet {

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
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/jsps/frame/left.jsp";
	}
}
