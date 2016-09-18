package cn.qdgxy.book.action;

import cn.qdgxy.book.service.BookService;
import cn.qdgxy.book.vo.Book;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookAction extends ActionSupport implements ModelDriven<Book> {

	private static final long serialVersionUID = 1L;
	private BookService bookService;
	private Book book = new Book();

	/**
	 * 图书添加
	 * 
	 * @return
	 */
	public String add() {
		System.out.println("图书添加。。。。。。。。。。。");
		bookService.add(book);
		return NONE;
	}
	
	public String findByIdLazy() {
		book = bookService.findByIdLazy(1);
		System.out.println(book);
		return NONE;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public Book getModel() {
		return book;
	}

}
