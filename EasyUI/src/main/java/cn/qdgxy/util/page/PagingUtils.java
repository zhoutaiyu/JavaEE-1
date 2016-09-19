package cn.qdgxy.util.page;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页
 * 
 * @author li119
 *
 */
public class PagingUtils {

	/**
	 * 得到URL(&pageNumber=前的URL)<br>
	 * 
	 * 例如：http://localhost:8080/day19/CustomerServlet?method=query&gender=%E7%94
	 * %B7&pageNumber=2
	 * 
	 * @param request
	 * 
	 * @return ： /day19/CustomerServlet?method=query&gender=%E7%94%B7
	 */
	public static String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath(); // /day19
		String servletPath = request.getServletPath(); // /CustomerServlet
		String queryString = request.getQueryString(); // ?method=query&gender=%E7%94%B7&pageNumber=2

		if (queryString != null && queryString.contains("&pageNumber=")) {
			int index = queryString.indexOf("&pageNumber=");
			queryString = queryString.substring(0, index);
		}

		return contextPath + servletPath + "?" + queryString;
	}

	/**
	 * 获取当前页码
	 * 
	 * @param request
	 * @return
	 */
	public static int getPageNumber(HttpServletRequest request) {
		// 得到pageNumber 如果pageNumber参数不存在，说明pageNumber=1
		// 如果pageNumber参数存在，需要转换成int类型即可
		String value = request.getParameter("page");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}

}
