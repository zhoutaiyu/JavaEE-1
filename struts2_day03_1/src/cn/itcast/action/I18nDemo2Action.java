package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

public class I18nDemo2Action extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String name;

	@Override
	public String execute() throws Exception {
		
		return NONE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "I18nDemo2Action [name=" + name + "]";
	}

}
