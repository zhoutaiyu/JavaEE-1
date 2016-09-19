package cn.qdgxy.util.page.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.qdgxy.util.page.domain.PageBean;

/**
 * 分页dao实现
 * 
 * @author li119
 *
 * @param <T>
 */
public class PagingDao<T> {

	/**
	 * 查询所有
	 * 
	 * @param qr
	 * @param pageNumber
	 *            当前页码
	 * @param pageSize
	 *            每页记录数
	 * @param totalRecordSql
	 *            查询总记录数sql语句
	 * @param beanListSql
	 *            查询数据语句
	 * @param type
	 *            查询生成的对象类型
	 * @return
	 */
	public PageBean<T> findAll(QueryRunner qr, int pageNumber, int pageSize, String totalRecordSql, String beanListSql, Class<T> type) {
		Object[] params = { (pageNumber - 1) * pageSize, pageSize };
		return findByCondition(qr, pageNumber, pageSize, totalRecordSql, beanListSql, null, params, type);
	}

	/**
	 * 
	 * 按条件查询
	 * 
	 * @param qr
	 * @param pageNumber
	 *            当前页码
	 * @param pageSize
	 *            每页记录数
	 * @param totalRecordSql
	 *            查询总记录数sql语句
	 * @param beanListSql
	 *            查询数据sql语句
	 * @param trParams
	 *            查询总记录数sql语句参数
	 * @param blParams
	 *            查询总记录数sql语句参数
	 * @param type
	 *            查询生成的对象类型
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageBean<T> findByCondition(QueryRunner qr, int pageNumber, int pageSize, String totalRecordSql, String beanListSql, Object[] trParams, Object[] blParams, Class<T> type) {
		try {
			// 1. 创建PageBean对象pb
			PageBean<T> pb = new PageBean<T>();

			// 2. 设置pb的当前页码和每页的记录数
			pb.setPageNumber(pageNumber);
			pb.setPageSize(pageSize);

			// 3. 得到总记录数，设置给pb
			Number num = (Number) qr.query(totalRecordSql, new ScalarHandler(), trParams);
			int totalRecord = num.intValue();
			pb.setTotalRecord(totalRecord);

			// 4. 得到beanList，设置给pb
			List<T> beanList = qr.query(beanListSql, new BeanListHandler<T>(type), blParams);
			pb.setBeanList(beanList);

			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
