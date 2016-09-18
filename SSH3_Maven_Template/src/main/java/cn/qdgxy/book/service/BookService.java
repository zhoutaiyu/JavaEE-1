package cn.qdgxy.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qdgxy.book.dao.BookDao;
import cn.qdgxy.book.vo.Book;

@Service("bookService")
@Transactional
public class BookService {

	@Autowired
	@Qualifier("bookDao")
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

	/**
	 * 删除图书
	 * 
	 * @param book
	 */
	/*
	 * public void delete(Book book) { bookDao.delete(book); }
	 *//**
	 * 修改图书
	 * 
	 * @param book
	 */
	/*
	 * public void update(Book book) { bookDao.update(book); }
	 *//**
	 * 按ID查找图书
	 * 
	 * @param book
	 */
	/*
	 * public Book findById(Integer bid) { return bookDao.findById(bid); }
	 *//**
	 * 查找所有
	 * 
	 * @return
	 */
	/*
	 * public List<Book> findAll() { return bookDao.findAll(); }
	 *//**
	 * 按条件查询
	 * 
	 * @return
	 */
	/*
	 * public List<Book> findByCriteria(DetachedCriteria criteria) { return
	 * bookDao.findByCriteria(criteria); }
	 *//**
	 * 按名称查询
	 * 
	 * @return
	 */
	/*
	 * public List<Book> findByName(String name) { return
	 * bookDao.findByName(name); }
	 *//**
	 * 按ID查询(延迟)
	 * 
	 * @param id
	 * @return
	 */
	/*
	 * public Book findByIdLazy(Integer id) { return bookDao.findByIdLazy(id); }
	 */

}
