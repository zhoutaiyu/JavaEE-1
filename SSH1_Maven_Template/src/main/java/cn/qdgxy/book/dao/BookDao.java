package cn.qdgxy.book.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.qdgxy.book.vo.Book;

public class BookDao extends HibernateDaoSupport {

	/**
	 * 保存图书
	 * 
	 * @param book
	 */
	public void save(Book book) {
		System.out.println("Dao 添加图书。。。。。。。。");
		this.getHibernateTemplate().save(book);
	}

}
