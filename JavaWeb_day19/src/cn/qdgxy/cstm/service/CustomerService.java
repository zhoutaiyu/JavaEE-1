package cn.qdgxy.cstm.service;

import cn.qdgxy.cstm.dao.CustomerDao;
import cn.qdgxy.cstm.domain.Customer;
import cn.qdgxy.cstm.domain.PageBean;

/**
 * 业务层
 * 
 * @author li119
 *
 */
public class CustomerService {

	private CustomerDao customerDao = new CustomerDao();
	
	/**
	 * 添加客户
	 * 
	 * @param c
	 */
	public void add(Customer c) {
		customerDao.add(c);
	}
	
	/**
	 * 查询所有客户
	 */
	public PageBean<Customer> findAll(int pc, int ps) {
		return customerDao.findAll(pc, ps);
	}

	/**
	 * 加载客户 
	 * 
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		return customerDao.load(cid);
	}

	/**
	 * 编辑客户
	 * 
	 * @param c
	 */
	public void edit(Customer c) {
		customerDao.edit(c);
	}

	/**
	 * 删除客户
	 * 
	 * @param cid
	 */
	public void delete(String cid) {
		customerDao.delete(cid);
	}

	/**
	 * 多条件组合查询
	 * 
	 * @param criteria
	 * @return
	 */
	public PageBean<Customer> query(Customer criteria, int pc, int ps) {
		return customerDao.query(criteria, pc, ps);
	}

}
