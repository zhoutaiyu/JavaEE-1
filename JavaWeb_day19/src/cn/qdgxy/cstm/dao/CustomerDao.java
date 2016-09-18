package cn.qdgxy.cstm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.qdgxy.cstm.domain.Customer;
import cn.qdgxy.cstm.domain.PageBean;

/**
 * 持久层
 * 
 * @author li119
 *
 */
public class CustomerDao {

	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加客户
	 * 
	 * @param c
	 */
	public void add(Customer c) {
		String sql = "INSERT INTO `t_customer` VALUES(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = { c.getCid(), c.getCname(), c.getGender(),
				c.getBirthday(), c.getCellphone(), c.getEmail(),
				c.getDescription() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询所有客户
	 * 
	 * @return
	 */
	public PageBean<Customer> findAll(int pc, int ps) {
		/*
		 * 1. 创建PageBean对象pb 2. 设置pb的pc和ps 3. 得到tr，设置给pb 4. 得到beanList，设置给pb 5.
		 * 返回pb
		 */
		try {
			PageBean<Customer> pb = new PageBean<Customer>();
			pb.setPc(pc);
			pb.setPs(ps);
			/*
			 * 得到tr
			 */
			String sql = "SELECT COUNT(*) FROM t_customer";
			Number num = (Number) qr.query(sql, new ScalarHandler());
			int tr = num.intValue();
			pb.setTr(tr);
			/*
			 * 得到BeanList
			 */
			sql = "SELECT * FROM t_customer ORDER BY cname LIMIT ?, ?";
			List<Customer> beanList = qr.query(sql,
					new BeanListHandler<Customer>(Customer.class), (pc - 1)
							* ps, ps);
			pb.setBeanList(beanList);
			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载客户
	 * 
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		String sql = "SELECT * FROM `t_customer` WHERE cid=?";
		try {
			return qr
					.query(sql, new BeanHandler<Customer>(Customer.class), cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑客户
	 * 
	 * @param c
	 */
	public void edit(Customer c) {
		String sql = "UPDATE `t_customer` SET cname=?, gender=?, birthday=?, "
				+ "cellphone=?, email=?, description=? WHERE cid=?";
		Object[] params = { c.getCname(), c.getGender(), c.getBirthday(),
				c.getCellphone(), c.getEmail(), c.getDescription(), c.getCid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param cid
	 */
	public void delete(String cid) {
		String sql = "DELETE FROM `t_customer` WHERE cid=?";
		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 多条件组合查询
	 * 
	 * @param criteria
	 * @return
	 */
	public PageBean<Customer> query(Customer criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象　 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 */
		try {
			/*
			 * 创建pb，设置已有属性
			 */
			PageBean<Customer> pb = new PageBean<Customer>();
			pb.setPc(pc);
			pb.setPs(ps);
			/*
			 * 得到tr
			 */
			StringBuilder cntSql = new StringBuilder(
					"SELECT COUNT(*) FROM t_customer ");
			StringBuilder whereSql = new StringBuilder(" WHERE 1=1 ");
			ArrayList<Object> params = new ArrayList<Object>();

			String cname = criteria.getCname();
			if (cname != null && !cname.trim().isEmpty()) {
				whereSql.append(" AND cname LIKE ? ");
				params.add("%" + cname + "%");
			}

			String gender = criteria.getGender();
			if (gender != null && !gender.trim().isEmpty()) {
				whereSql.append(" AND gender=? ");
				params.add(gender);
			}

			String cellphone = criteria.getCellphone();
			if (cellphone != null && !cellphone.trim().isEmpty()) {
				whereSql.append(" AND cellphone LIKE ? ");
				params.add("%" + cellphone + "%");
			}

			String email = criteria.getEmail();
			if (email != null && !email.trim().isEmpty()) {
				whereSql.append(" AND email LIKE ? ");
				params.add("%" + email + "%");
			}

			// COUNT(*) 得使用Number
			Number number = (Number) qr.query(cntSql.append(whereSql)
					.toString(), new ScalarHandler(), params.toArray());
			int tr = number.intValue();
			pb.setTr(tr);

			/*
			 * 得到beanList
			 */
			StringBuilder sql = new StringBuilder("SELECT * FROM t_customer ");
			// 还需要limit字句
			StringBuilder limitSql = new StringBuilder(" LIMIT ?, ? ");
			// params中需要给出limit后两个问号对应的值
			params.add((pc - 1) * ps);
			params.add(ps);
			// 执行
			List<Customer> list = qr.query(sql.append(whereSql)
					.append(limitSql).toString(),
					new BeanListHandler<Customer>(Customer.class),
					params.toArray());
			pb.setBeanList(list);
			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
