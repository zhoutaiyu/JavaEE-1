<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>BookStore</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="/jsps/frame/head.jsp"%>
</head>

<body>
<div id="wrap">
	<%-- 页面顶部 --%>
	<%@ include file="/jsps/frame/top.jsp"%>

	<div class="center_content">
		<%-- 页面左边 --%>
		<div class="left_content">
			<div class="new_products">
				<c:forEach var="book" items="${pb.beanList}">
					<div class="new_prod_box">
						<div class="booktitle">
							<a href="<c:url value='/BookServlet?method=load&bid=${book.bid}' />">${book.bname}</a>
						</div>
						<div class="new_prod_bg">
							<a href="<c:url value='/BookServlet?method=load&bid=${book.bid}' />">
								<img src="<c:url value='/${book.image}'/>" alt="" title="" class="thumb" />
							</a>
						</div>
					</div>
				</c:forEach>
				<%-- 分页 --%>
				<%@ include file="/common/paging.jsp" %>
			</div>
			<div class="clear"></div>
		</div>

		<%-- 页面右边 --%>
		<%@ include file="/jsps/frame/right.jsp"%>
	</div>

	<%-- 页面底部 --%>
	<%@ include file="/jsps/frame/bottom.jsp"%>
</div>
</body>
</html>