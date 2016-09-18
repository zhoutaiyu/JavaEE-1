package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

public class I18nDemo1Action extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println(this.getText("msg"));
		return NONE;
	}

}
