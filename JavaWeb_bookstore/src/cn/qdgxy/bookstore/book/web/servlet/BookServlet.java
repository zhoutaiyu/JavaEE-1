package cn.qdgxy.bookstore.book.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.bookstore.book.domain.Book;
import cn.qdgxy.bookstore.book.service.BookService;
import cn.qdgxy.bookstore.util.page.domain.PageBean;
import cn.qdgxy.bookstore.util.page.domain.Paging;

@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();

	/**
	 * 查询所有图书
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 获取页面传递的页码
		int pageNumber = Paging.getPageNumber(request);

		// 2. 得到PageBean
		PageBean<Book> pb = bookService.findAll(pageNumber, Paging.pageSize);
		// 设置URL
		pb.setUrl(Paging.getUrl(request));

		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}

	/**
	 * 查询所有图书（时间排序）
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllSortTime(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 获取页面传递的页码
		int pageNumber = Paging.getPageNumber(request);

		// 2. 得到PageBean
		PageBean<Book> pb = bookService.findAllSortTime(pageNumber,
				Paging.pageSize);
		// 设置URL
		pb.setUrl(Paging.getUrl(request));

		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}

	/**
	 * 按分类查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 获取页面传递的页码
		int pageNumber = Paging.getPageNumber(request);

		// 2. 得到PageBean
		String cid = request.getParameter("cid");
		PageBean<Book> pb = bookService.findByCategory(cid, pageNumber,
				Paging.pageSize);
		// 设置URL
		pb.setUrl(Paging.getUrl(request));

		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}

	/**
	 * 加载图书详情
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
		return "f:/jsps/book/desc.jsp";
	}

}
