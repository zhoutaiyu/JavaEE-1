<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>商品列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<%-- 公共CSS --%>
<%@ include file="/WEB-INF/jsps/frame/head.jsp"%>

<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
</head>

<body>
	<%-- 页面顶部 --%>
	<%@ include file="/WEB-INF/jsps/frame/top.jsp"%>

	<div class="container productList">
	    <%-- 页面左侧--%>
		<%@ include file="/WEB-INF/jsps/frame/left.jsp"%>

	    <div class="span18 last">
            <div id="result" class="result table clearfix">
                <ul>
                	<s:iterator value="pageBean.beanList" var="bl">
	                    <li> 
	                    	<s:url namespace="/" action="product_load" var="productDetailUrl">
	                    		<s:param name="pid" value="#bl.pid" />
	                    	</s:url>
	                    
	                    	<a href='<s:property value="#productDetailUrl"/>'> 
	                    		<img src="${pageContext.request.contextPath}/<s:property value='#bl.image' />" width="170" height="170" style="display: inline-block;" /> 
	                    		<span style="color:green"><s:property value="#bl.pname"/></span> 
	                    		<span class="price"> shop价： ￥<s:property value="#bl.shop_price"/> </span> 
	                    	</a>
	                    </li>
                    </s:iterator>
                </ul>
            </div>
            
           	<%-- 分页 --%>
            <%@ include file="/WEB-INF/common/pagination.jsp"%>
	    </div>
	</div>

	<%-- 页面底部 --%>
	<%@ include file="/WEB-INF/jsps/frame/bottom.jsp"%>
</body>
</html>
