package cn.qdgxy.bookstore.book.service;

import java.util.List;

import cn.qdgxy.bookstore.book.dao.BookDao;
import cn.qdgxy.bookstore.book.domain.Book;
import cn.qdgxy.bookstore.util.page.domain.PageBean;

public class BookService {

	private BookDao bookDao = new BookDao();

	/**
	 * 查找所有图书(分页)
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Book> findAll(int pageNumber, int pageSize) {
		return bookDao.findAll(pageNumber, pageSize);
	}

	/**
	 * 查找所有图书(分页、时间排序)
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Book> findAllSortTime(int pageNumber, int pageSize) {
		return bookDao.findAllSortTime(pageNumber, pageSize);
	}

	/**
	 * 按分类查找图书
	 * 
	 * @param cid
	 * @return
	 */
	@Deprecated
	public List<Book> findByCategory(String cid) {
		return bookDao.findByCategory(cid);
	}

	/**
	 * 按分类查找图书(分页)
	 * 
	 * @param cid
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Book> findByCategory(String cid, int pageNumber,
			int pageSize) {
		return bookDao.findByCategory(cid, pageNumber, pageSize);
	}

	/**
	 * 加载图书详情
	 * 
	 * @param bid
	 * @return
	 */
	public Book load(String bid) {
		return bookDao.findById(bid);
	}

	/**
	 * 添加图书
	 * 
	 * @param book
	 */
	public void add(Book book) {
		bookDao.add(book);
	}

	/**
	 * 删除图书
	 * 
	 * @param book
	 */
	public void delete(String bid) {
		bookDao.delete(bid);
	}

	/**
	 * 修改图书
	 * 
	 * @param book
	 */
	public void edit(Book book) {
		bookDao.edit(book);
	}

}
