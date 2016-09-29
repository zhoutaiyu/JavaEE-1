package cn.itcast.interceotor;

import org.apache.struts2.ServletActionContext;

import cn.itcast.action.BookAction;
import cn.itcast.domain.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BookInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 得到session中的user
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");

		if (user == null) {
			BookAction action = (BookAction) invocation.getAction(); // 得到当前的action对象
			action.addActionError("权限不足！请先登录");
			return Action.LOGIN;
		}

		return invocation.invoke();
	}

}
