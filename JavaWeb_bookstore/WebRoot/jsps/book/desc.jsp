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
			<!-- 书名 -->
			<div class="title">
				<span class="title_icon"><img src="<c:url value='/images/websit/bullet1.gif' />" alt="" title="" /></span>${book.bname}
			</div>
			<div class="feat_prod_box_details">
				<div class="prod_img">
					<!-- 图书图片 -->
					<a href="details.htm"><img src="<c:url value='/${book.image}'/>" alt="" title="" /></a>
				</div>
				<div class="prod_det_box">
					<div class="box_top"></div>
					<div class="box_center">
						<!-- 图书介绍 -->
						<div class="prod_title"></div>
						<p class="details"></p>
						<!-- 图书作者 -->
						<div class="price">
							<strong>作者:</strong> <span class="red">${book.author}</span>
						</div>
						<!-- 图书价格 -->
						<div class="price">
							<strong>价格:</strong> <span class="red">${book.price} ￥</span>
						</div>
						<form action="<c:url value='/CartServlet'/>" method="post" id="form">
							<input type="hidden" name="method" value="add" /> 
							<input type="hidden" name="bid" value="${book.bid}" /> 
							<div class="price">
								<strong>数量:</strong> <input type="text" name="count" value="1" />　${msg}
							</div>
						</form>
						<!-- 购买链接 -->
						<a href="javascript:document.getElementById('form').submit();" class="more">
							<img src="<c:url value='/images/websit/order_now.gif' />" alt="" title="" />
						</a>
						<div class="clear"></div>
					</div>
					<div class="box_bottom"></div>
				</div>
				<div class="clear"></div>
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