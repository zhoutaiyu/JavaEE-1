<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
			<div class="title">
				<span class="title_icon"><img src="images/websit/bullet1.gif" alt="" title="" /></span>购物车
			</div>
			<c:choose>
				<c:when test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartItems) eq 0}">
					<div class="clear"></div>
					<img alt="" src="<c:url value='/images/cart.png' />">
				</c:when>
				<c:otherwise>
					<div class="feat_prod_box_details">
						<table class="cart_table">
							<tr class="cart_title">
								<td>图书名</td>
								<td>价 格</td>
								<td>数 量</td>
								<td>小 计</td>
								<td>操 作</td>
							</tr>
							<c:forEach var="carItem" items="${sessionScope.cart.cartItems}">
								<tr>
									<td>${carItem.book.bname}</td>
									<td>${carItem.book.price}￥</td>
									<td>${carItem.count}</td>
									<td>${carItem.subtotal}￥</td>
									<td><a href="<c:url value='/CartServlet?method=delete&bid=${carItem.book.bid}'/>">删除</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="4" class="cart_total"><span class="red">合计:</span></td>
								<td>${sessionScope.cart.total}￥</td>
							</tr>
						</table>
						<a href="<c:url value='/CartServlet?method=clear'/>" class="continue">清空购物车</a> <a href="<c:url value='/OrderServlet?method=add'/>" class="checkout">确认购买&gt;&gt;</a>
					</div>
				</c:otherwise>
			</c:choose>
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