package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String add() {

		System.out.println("product add");
		return NONE;
	}

	public String update() {

		System.out.println("product update");
		return NONE;
	}

	public String delete() {

		System.out.println("product delete");
		return NONE;
	}

	public String search() {

		System.out.println("product search");
		return NONE;
	}

}
