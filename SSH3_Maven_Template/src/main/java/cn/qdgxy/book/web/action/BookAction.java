package cn.qdgxy.book.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.qdgxy.book.service.BookService;
import cn.qdgxy.book.vo.Book;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/")
@Controller("bookAction")
@Scope("prototype")
public class BookAction extends ActionSupport implements ModelDriven<Book> {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("bookService")
	private BookService bookService;

	private Book book = new Book();

	/**
	 * 图书添加
	 * 
	 * @return
	 */
	@Action("book_add")
	public String add() {
		System.out.println("图书添加。。。。。。。。。。。");
		bookService.add(book);
		return NONE;
	}

	@Override
	public Book getModel() {
		return book;
	}

}
