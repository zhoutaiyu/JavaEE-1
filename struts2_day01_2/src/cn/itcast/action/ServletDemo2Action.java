package cn.itcast.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

//获取servlet api  通过ActionContext获取
public class ServletDemo2Action extends ActionSupport implements
		ServletRequestAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		System.out.println(request.getParameter("username"));
		return NONE;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

}
