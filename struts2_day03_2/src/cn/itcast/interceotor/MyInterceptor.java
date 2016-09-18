package cn.itcast.interceotor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
		System.out.println("MyInterceptor init。。。。。");
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("MyInterceptor 拦截。。。。。");
		//return ai.invoke();	// 放行
		return Action.LOGIN;
	}

}
