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
				<div class="title">
					<span class="title_icon"><img src="images/websit/bullet1.gif" alt="" title="" /></span>个人中心
				</div>
				<div class="feat_prod_box_details">
				<div class="msg">${msg }</div>
					<div class="contact_form">
						<div class="form_subtitle">我的信息</div>
						<form name="register" action="<c:url value='/UserServlet' />" method="post">
						<input type="hidden" name="method" value="update" />
						<input type="hidden" name="uid" value="${session_user.uid}" />
							<div class="form_row">
								<label class="contact"><strong>用户名:</strong></label> 
								<input type="text" class="contact_input" name="username" value="${session_user.username}" />
								<div class="contact2" id="usernameVerify">${errors.username}</div>
							</div>
							<div class="form_row">
								<label class="contact"><strong>密　 码:</strong></label> 
								<input type="password" class="contact_input" name="password" value="" />
								<div class="contact2" >${errors.password}</div>
							</div>
							<div class="form_row">
								<label class="contact"><strong>邮　 箱:</strong></label> 
								<input type="text" class="contact_input" name="email" value="${session_user.email}" />
								<div class="contact2" id="emailVerify" >${errors.email}</div>
							</div>
							<div class="form_row">
								<label class="contact"><strong>收货人:</strong></label> 
								<input type="text" class="contact_input" name="consignee" value="${session_user.consignee}" />
								<div class="contact2" >${errors.consignee}</div>
							</div>
							<div class="form_row">
								<label class="contact"><strong>手　 机:</strong></label> 
								<input type="text" class="contact_input" name="phone" value="${session_user.phone}" />
								<div class="contact2" >${errors.phone}</div>
							</div>
							<div class="form_row">
								<label class="contact"><strong>地　 址:</strong></label> 
								<input type="text" class="contact_input" name="adress" value="${session_user.adress}" />
								<div class="contact2" >${errors.adress}</div>
							</div>
							<div class="form_row">
								<input type="submit" class="register" value="修改" />
							</div>
						</form>
					</div>
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
