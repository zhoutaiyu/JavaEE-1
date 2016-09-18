package cn.itcast.action;

import java.util.List;

import cn.itcast.service.CustomerService;
import cn.itcast.vo.Customer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements
		ModelDriven<Customer> {

	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerService();

	private Customer customer = new Customer();
	private List<Customer> customers;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public String findAll() {
		customers = customerService.findAll();
		return "findAll_success";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		customerService.delete(customer);
		return "delete_success";
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

}
