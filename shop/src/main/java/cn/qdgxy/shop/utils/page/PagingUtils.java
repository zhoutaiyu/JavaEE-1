package cn.qdgxy.shop.utils.page;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页
 *
 * @author li119
 */
public class PagingUtils {

    /**
     * 得到URL(&pageNumber=前的URL)<br>
     * <p>
     * 例如：http://localhost:8080/day19/CustomerServlet?method=query&gender=%E7%94
     * %B7&pageNumber=2
     *
     * @param request 请求
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
     * @param pageNumber 网页获得的当前页码
     * @return 查询页码
     */
    public static int getPageNumber(Integer pageNumber) {
        // 如果pageNumber参数不存在，说明pageNumber=1
        return pageNumber == null ? 1 : pageNumber;
    }

}
