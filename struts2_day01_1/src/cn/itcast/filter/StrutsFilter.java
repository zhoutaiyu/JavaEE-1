package cn.itcast.filter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

@WebFilter("/*")
public class StrutsFilter implements Filter {

	public StrutsFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 1. 强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 2. 操作

		// 2.1 得到请求资源路径
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length() + 1);

		// 2.2 使用path去struts.xml文件中查找某一个<action name=path>这个标签
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File(this.getClass()
					.getResource("/struts.xml").getPath()));
			Element actionElement = (Element) document
					.selectSingleNode("//action[@name='" + path + "']");

			if (actionElement != null) {
				// 得到<action>标签上的class属性以及method属性
				String className = actionElement.attributeValue("class"); // 得到了action类的名称
				String methodName = actionElement.attributeValue("method"); // 得到action类中的方法名称

				// 2.3 通过反射，得到Class对象，得到Method对象
				Class<?> actionClass = Class.forName(className);
				Method method = actionClass.getDeclaredMethod(methodName);

				Object actionObj = actionClass.newInstance();

				// 处理请求参数封装
				// ② 模型驱动
				if (actionObj instanceof MyModelDriven<?>) {
					MyModelDriven<?> mmd = (MyModelDriven<?>) actionObj;

					BeanUtils.populate(mmd.getModel(),
							request.getParameterMap());
				} else {
					// ① 属性驱动
					BeanUtils.populate(actionObj, request.getParameterMap());
				}

				// 2.4 让method执行
				String resultValue = (String) method.invoke(actionObj); // 是让action类中的方法执行，并获取方法的返回值

				// 2.5
				// 使用returnValue去action下查找其子元素result的name属性值，与returnValue做对比。
				Element resultElement = actionElement.element("result");
				String nameValue = resultElement.attributeValue("name");

				if (resultValue.equals(nameValue)) {
					String skipPath = resultElement.getText();

					request.getRequestDispatcher(skipPath).forward(request,
							response);
					return;
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		// 3. 放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
