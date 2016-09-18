package cn.itcast.user.web.interceptor;

import cn.itcast.user.exception.MySQLException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			return invocation.invoke();
		} catch (MySQLException e) {
			// 捕获自定义异常
			// 记录日志 log4j
			// 跳转优化页面
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError(e.getMessage());
			System.out.println(e.getMessage());
			return "error";
		}
	}

}
