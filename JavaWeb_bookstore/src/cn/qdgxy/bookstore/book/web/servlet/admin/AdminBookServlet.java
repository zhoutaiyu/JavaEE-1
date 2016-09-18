package cn.qdgxy.bookstore.book.web.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.book.domain.Book;
import cn.qdgxy.bookstore.book.service.BookService;
import cn.qdgxy.bookstore.category.domain.Category;
import cn.qdgxy.bookstore.category.service.CategoryService;
import cn.qdgxy.bookstore.util.page.domain.PageBean;
import cn.qdgxy.bookstore.util.page.domain.Paging;

@WebServlet("/admin/AdminBookServlet")
public class AdminBookServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();

	/**
	 * 查看所有图书
	 */
	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 获取页面传递的页码
		int apgeNumber = Paging.getPageNumber(request);

		// 2. 得到PageBean
		PageBean<Book> pb = bookService.findAllSortTime(apgeNumber,
				Paging.pageSize);
		// 设置URL
		pb.setUrl(Paging.getUrl(request));

		request.setAttribute("pb", pb);
		return "f:/adminjsps/admin/book/list.jsp";
	}

	/**
	 * 加载图书
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("book",
				bookService.load(request.getParameter("bid")));
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/book/desc.jsp";
	}

	/**
	 * 添加图书
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addPre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/book/add.jsp";
	}

	/**
	 * 删除图书
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		bookService.delete(bid);
		return findAll(request, response);
	}

	/**
	 * 修改图书
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
		Category category = CommonUtils.toBean(request.getParameterMap(),
				Category.class);
		book.setCategory(category);
		bookService.edit(book);
		return "f:/admin/AdminBookServlet?method=findAll";
	}

}
