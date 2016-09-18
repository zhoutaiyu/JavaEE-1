package cn.qdgxy.book.service;

import org.springframework.transaction.annotation.Transactional;

import cn.qdgxy.book.dao.BookDao;
import cn.qdgxy.book.vo.Book;

@Transactional
public class BookService {

	private BookDao bookDao;

	/**
	 * 添加图书
	 * 
	 * @param book
	 */
	public void add(Book book) {
		System.out.println("Service 添加图书。。。。。。。。");
		bookDao.save(book);
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
