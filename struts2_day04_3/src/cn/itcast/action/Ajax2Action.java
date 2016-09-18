package cn.itcast.action;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.domain.Product;

import com.opensymphony.xwork2.ActionSupport;

public class Ajax2Action extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Product> ps = null;

	@Override
	public String execute() throws Exception {
		ps = new ArrayList<Product>();

		ps.add(new Product(1, "洗衣机", 1800d, 10));
		ps.add(new Product(2, "电视", 1200d, 100));
		ps.add(new Product(3, "空调", 2000d, 50));

		return SUCCESS;
	}

	public List<Product> getPs() {
		return ps;
	}

	public void setPs(List<Product> ps) {
		this.ps = ps;
	}

}
