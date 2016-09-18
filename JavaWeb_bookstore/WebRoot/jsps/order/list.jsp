<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
			<div class="title">我的订单</div>
			<div class="feat_prod_box_details">
				<table class="cart_table">
					<tr class="cart_title">
						<td>订单编号</td>
						<td>成交时间</td>
						<td>金额</td>
						<td>状态</td>
					</tr>
					<c:forEach var="order" items="${pb.beanList}">
						<tr>
							<td>
								<a href="<c:url value='/OrderServlet?method=load&oid=${order.oid}'/>">
									${order.oid}
								</a>
							</td>
							<td><fmt:formatDate value="${order.ordertime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${order.total}￥</td>
							<td>
								<c:choose>
									<c:when test="${order.state eq 1}">
										<a href="<c:url value='/OrderServlet?method=prePay&oid=${order.oid}'/>">付款</a> 
									</c:when>
									<c:when test="${order.state eq 2}">等待发货</c:when>
									<c:when test="${order.state eq 3}">
										<a href="<c:url value='/OrderServlet?method=confirm&oid=${order.oid}'/>">确认收货</a>
									</c:when>
									<c:when test="${order.state eq 4}">交易成功</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<%-- 分页 --%>
			<%@ include file="/common/paging.jsp" %>
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
