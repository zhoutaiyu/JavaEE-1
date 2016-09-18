package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.CustomerDao;
import cn.itcast.vo.Customer;

public class CustomerService {

	private CustomerDao customerDao = new CustomerDao();

	/**
	 * 查询所有客户
	 * 
	 * @return
	 */
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	/**
	 * 删除
	 * 
	 * @param customer
	 */
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

}
