package cn.itcast.user.web.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.itcast.user.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 登录拦截器
 * 
 * @author 李欣
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");

		if (user == null) { // 未登录
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("用户未登录！");

			return ActionSupport.LOGIN;
		} else {
			return invocation.invoke();
		}
	}

}
