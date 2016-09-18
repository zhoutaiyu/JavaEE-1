<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<style type="text/css">
* {
	font-size: 11pt;
}

li {
	margin: 10px;
}

body{
	background:rgb(254, 238, 189)
}
</style>
</head>

<body>
	<table border="1" width="100%" cellspacing="0" background="black">
		<c:forEach var="order" items="${pb.beanList}">
			<tr bgcolor="gray" bordercolor="gray">
				<td colspan="6">
					订单编号：${order.oid}　
					成交时间：<fmt:formatDate value="${order.ordertime}" pattern="yyyy-MM-dd HH:mm:ss"/>　
					金额：<font color="red"><b>${order.total}元</b></font>　
					<c:choose>
						<c:when test="${order.state eq 1}">等待付款</c:when>
						<c:when test="${order.state eq 2}">
							<a href="<c:url value='/admin/AdminOrderServlet?method=ship&oid=${order.oid}'/>">发货</a>
						</c:when>
						<c:when test="${order.state eq 3}">等待确认收货</c:when>
						<c:when test="${order.state eq 4}">交易成功</c:when>
					</c:choose>
					<br>
					收件人：${order.consignee}　
					手机：${order.phone}　
					地址：${order.address}
				</td>
			</tr>
			<c:forEach var="orderItem" items="${order.orderItemList}">
				<tr bordercolor="gray" align="center">
					<td width="15%">
						<div>
							<img src="<c:url value='/${orderItem.book.image}'/>" height="75" />
						</div>
					</td>
					<td>书名：${orderItem.book.bname}</td>
					<td>单价：${orderItem.book.price}元</td>
					<td>作者：${orderItem.book.author}</td>
					<td>数量：${orderItem.count}</td>
					<td>小计：${orderItem.subtotal}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
		
	<%@ include file="/common/paging.jsp" %>
</body>
</html>
