package cn.qdgxy.shop.utils.page.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

/**
 * Hibernate 实现分页
 * 
 * @author 李欣
 *
 * @param <T>
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

	private String hql; // hql语句
	private Object[] params; // 参数
	private int startIndex; // 当前页码，从0开始
	private int pageSize; // 每页记录数

	public PageHibernateCallback(String hql, Object[] params, int startIndex,
			int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<T> doInHibernate(Session session) throws HibernateException {
		// 1. 执行hql语句
		Query<T> query = session.createQuery(hql);

		// 2. 实际参数
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		// 3. 分页
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);

		return query.list();
	}

}
