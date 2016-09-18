package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String add() throws Exception {
		System.out.println("BookAction add.....");
		return NONE;
	}

	public String delete() throws Exception {
		System.out.println("BookAction delete.....");
		return NONE;
	}

	public String update() throws Exception {
		System.out.println("BookAction update.....");
		return NONE;
	}

	public String search() throws Exception {
		System.out.println("BookAction search.....");
		return NONE;
	}

}
