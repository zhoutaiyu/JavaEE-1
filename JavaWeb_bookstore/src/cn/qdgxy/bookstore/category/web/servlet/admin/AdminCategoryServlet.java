package cn.qdgxy.bookstore.category.web.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.category.domain.Category;
import cn.qdgxy.bookstore.category.service.CategoryService;

@WebServlet("/admin/AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = new CategoryService();

	/**
	 * 查找所有分类
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
		return "f:/adminjsps/admin/category/list.jsp";
	}

	/**
	 * 添加分类
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category form = CommonUtils.toBean(request.getParameterMap(),
				Category.class);
		form.setCid(CommonUtils.uuid());
		categoryService.add(form);
		return this.findAll(request, response);
	}

	/**
	 * 删除分类
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		try {
			categoryService.delete(cid);
			return this.findAll(request, response);
		} catch (CategoryException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/adminjsps/admin/msg.jsp";
		}
	}

	/**
	 * 修改之前的加载工作
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String editPre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		request.setAttribute("category", categoryService.load(cid));
		return "f:/adminjsps/admin/category/mod.jsp";
	}

	/**
	 * 修改分类
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category form = CommonUtils.toBean(request.getParameterMap(), Category.class);
		categoryService.edit(form);
		return findAll(request, response);
	}

}
