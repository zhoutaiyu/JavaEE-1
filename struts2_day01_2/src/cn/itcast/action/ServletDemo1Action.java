package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//获取servlet api  通过ActionContext获取
public class ServletDemo1Action extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// 1.获取ActionContext
		ActionContext context = ActionContext.getContext();

		// 2.获取Servlet api

		// // 2.1 获取application中数据
		// Map<String, Object> applicationMap = context.getApplication();
		// System.out.println(applicationMap.get("aname"));
		//
		// // 2.2 获取session中数据
		// Map<String, Object> sessionMap = context.getSession();
		// System.out.println(sessionMap);
		//
		// // 2.3 获取请求参数
		// Map<String, Object> parametersMap = context.getParameters(); //
		// request.getParameterMap();
		// System.out.println(((String[]) (parametersMap.get("username")))[0]);

		// 2.4 向request范围存储数据
		context.put("username", "123");

		return SUCCESS;
	}

}
