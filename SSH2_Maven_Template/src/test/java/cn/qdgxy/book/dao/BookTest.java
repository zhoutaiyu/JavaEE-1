package cn.qdgxy.book.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.qdgxy.book.service.BookService;
import cn.qdgxy.book.vo.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookTest {

	@Autowired
	@Qualifier("bookService")
	private BookService bookService;

	@Test
	public void testAdd() throws Exception {
		Book book = new Book();
		book.setBid(100);
		book.setName("JavaEE");
		book.setPrice(49d);

		bookService.add(book);
	}

	@Test
	public void testDelete() throws Exception {
		Book book = new Book();
		book.setBid(2);

		bookService.delete(book);
	}

	@Test
	public void testFindById() throws Exception {
		Book book = bookService.findById(3);
		System.out.println(book);
	}

	@Test
	public void testFindAll() throws Exception {
		List<Book> books = bookService.findAll();

		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testFindByCriteria() throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		criteria.add(Restrictions.eq("name", "JavaEE"));
		List<Book> books = bookService.findByCriteria(criteria);

		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testFindByName() throws Exception {
		List<Book> books = bookService.findByName("JavaEE");

		for (Book book : books) {
			System.out.println(book);
		}
	}

}
