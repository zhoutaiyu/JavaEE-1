package cn.qdgxy.bookstore.book.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.qdgxy.bookstore.book.domain.Book;
import cn.qdgxy.bookstore.category.domain.Category;
import cn.qdgxy.bookstore.util.page.dao.PagingDao;
import cn.qdgxy.bookstore.util.page.domain.PageBean;

public class BookDao {

	private QueryRunner qr = new TxQueryRunner();
	private PagingDao<Book> pagingDao = new PagingDao<Book>();

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	@Deprecated
	public List<Book> findAll() {
		String sql = "SELECT * FROM `book` WHERE `del`=FALSE";
		try {
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找所有图书（分页）
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Book> findAll(int pageNumber, int pageSize) {
		String totalRecordSql = "SELECT COUNT(*) FROM `book` WHERE `del`=FALSE";
		String beanListSql = "SELECT * FROM `book` WHERE `del`=FALSE LIMIT ?, ?";
		return pagingDao.findAll(qr, pageNumber, pageSize, totalRecordSql,
				beanListSql, Book.class);
	}

	/**
	 * 查找所有图书（分页、时间排序）
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Book> findAllSortTime(int pageNumber, int pageSize) {
		String totalRecordSql = "SELECT COUNT(*) FROM `book` WHERE `del`=FALSE";
		String beanListSql = "SELECT * FROM `book` WHERE `del`=FALSE  ORDER BY `addtime` DESC LIMIT ?, ?";
		return pagingDao.findAll(qr, pageNumber, pageSize, totalRecordSql,
				beanListSql, Book.class);
	}

	/**
	 * 按分类查询
	 * 
	 * @param cid
	 * @return
	 */
	@Deprecated
	public List<Book> findByCategory(String cid) {
		String sql = "SELECT * FROM `book` WHERE cid=? AND `del`=FALSE";
		try {
			return qr.query(sql, new BeanListHandler<Book>(Book.class), cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按分类查询(分页)
	 * 
	 * @param cid
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean<Book> findByCategory(String cid, int pageNumber,
			int pageSize) {
		String totalRecordSql = "SELECT COUNT(*) FROM `book` WHERE cid=? AND `del`=FALSE";
		String beanListSql = "SELECT * FROM `book` WHERE cid=? AND `del`=FALSE LIMIT ?, ?";
		Object[] trParams = { cid };
		Object[] blParams = { cid, (pageNumber - 1) * pageSize, pageSize };

		return pagingDao.findByCondition(qr, pageNumber, pageSize,
				totalRecordSql, beanListSql, trParams, blParams, Book.class);
	}

	/**
	 * 按ID查询
	 * 
	 * @param bid
	 * @return
	 */
	public Book findById(String bid) {
		String sql = "SELECT * FROM `book` WHERE bid=?";
		try {
			// 需要在Book对象中保存Category的信息
			Map<String, Object> map = qr.query(sql, new MapHandler(), bid);
			// 使用一个Map，映射出两个对象，再给这两个对象建立关系
			Book book = CommonUtils.toBean(map, Book.class);
			Category category = CommonUtils.toBean(map, Category.class);
			book.setCategory(category);
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询指定分类下的图书数
	 * 
	 * @param cid
	 * @return
	 */
	public int getCountByCid(String cid) {
		String sql = "SELECT COUNT(*) FROM `book` WHERE cid=?";
		try {
			Number count = (Number) qr.query(sql, new ScalarHandler(), cid);
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加图书
	 * 
	 * @param book
	 */
	public void add(Book book) {
		String sql = "INSERT INTO `book` VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		/*
		 * 处理util的Date转换成sql的timestamp
		 */
		Timestamp addtime = new Timestamp(book.getAddtime().getTime());
		Object[] params = { book.getBid(), book.getBname(), book.getPrice(),
				book.getAuthor(), book.getImage(), book.getCategory().getCid(),
				addtime, false };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除图书（实际未删除）
	 * 
	 * @param book
	 */
	public void delete(String bid) {
		String sql = "UPDATE `book` set `del`=TRUE WHERE bid=?";
		try {
			qr.update(sql, bid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改图书
	 * 
	 * @param book
	 */
	public void edit(Book book) {
		String sql = "UPDATE `book` SET bname=?, price=?, author=?, image=?, cid=? WHERE bid=?";
		Object[] params = { book.getBname(), book.getPrice(), book.getAuthor(),
				book.getImage(), book.getCategory().getCid(), book.getBid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
