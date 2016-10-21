package cn.qdgxy.book.dao;

import cn.qdgxy.book.vo.Book;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BookDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    /**
     * 保存图书
     *
     * @param book
     */
    public void save(Book book) {
        System.out.println("Dao 添加图书。。。。。。。。");
        hibernateTemplate.save(book);
    }

    /**
     * 修改图书
     *
     * @param book
     */
    /*
     * public void update(Book book) { this.getHibernateTemplate().update(book);
	 * }
	 *//**
     * 删除图书
     *
     * @param book
     */
	/*
	 * public void delete(Book book) { this.getHibernateTemplate().delete(book);
	 * }
	 *//**
     * 按ID查询
     *
     * @param id
     * @return
     */
	/*
	 * public Book findById(Integer id) { return
	 * this.getHibernateTemplate().get(Book.class, id); }
	 *//**
     * 查找所有
     *
     * @return
     */
	/*
	 * @SuppressWarnings("unchecked") public List<Book> findAll() { return
	 * (List<Book>) this.getHibernateTemplate().find("from Book"); }
	 *//**
     * 按条件查询
     *
     * @return
     */
	/*
	 * @SuppressWarnings("unchecked") public List<Book>
	 * findByCriteria(DetachedCriteria criteria) { return (List<Book>)
	 * this.getHibernateTemplate() .findByCriteria(criteria); }
	 *//**
     * 按名称查询
     *
     * @return
     */
	/*
	 * @SuppressWarnings("unchecked") public List<Book> findByName(String name)
	 * { return (List<Book>) this.getHibernateTemplate().findByNamedQuery(
	 * "findByName", name); }
	 *//**
     * 按ID查询(延迟)
     *
     * @param id
     * @return
     */
	/*
	 * public Book findByIdLazy(Integer id) { return
	 * this.getHibernateTemplate().load(Book.class, id); }
	 */

}
