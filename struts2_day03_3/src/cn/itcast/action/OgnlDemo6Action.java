package cn.itcast.action;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.domain.Product;

import com.opensymphony.xwork2.ActionSupport;

public class OgnlDemo6Action extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Product> ps = null;

	@Override
	public String execute() throws Exception {
		ps = new ArrayList<Product>();

		ps.add(new Product("电脑", 3400d, 200));
		ps.add(new Product("洗衣机", 1000d, 100));
		ps.add(new Product("空调", 2000d, 50));

		return SUCCESS;
	}

	public List<Product> getPs() {
		return ps;
	}

	public void setPs(List<Product> ps) {
		this.ps = ps;
	}

}
