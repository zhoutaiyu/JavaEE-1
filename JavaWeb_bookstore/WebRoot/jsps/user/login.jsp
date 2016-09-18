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
				<span class="title_icon">
				<img src="images/websit/bullet1.gif" alt="" title="" /></span>我的账户
			</div>
			<div class="feat_prod_box_details">
				<div class="msg">${msg }</div>
				<div class="contact_form">
					<div class="form_subtitle">请登录</div>
					<form name="register" action="<c:url value='/UserServlet'/>" method="post">
						<input type="hidden" name="method" value="login" /> 
						<div class="form_row">
							<label class="contact"><strong>用户名:</strong></label> 
							<input type="text" class="contact_input"  name="username" id="username" value="${form.username}" />
							<div class="contact2" id="usernameVerify">${errors.username }</div>
						</div>
						<div class="form_row">
							<label class="contact"><strong>密　 码:</strong></label> 
							<input type="password" class="contact_input" name="password" value="${form.password}" />
							<div class="contact2" >${errors.password }</div>
						</div>
						<div class="form_row">
							<label class="contact"><strong>验证码:</strong></label> 
							<input type="text" class="contact_input" name="verifyCode" value="${user.verifyCode }" id="veryfyinput" />
							<div class="contact2">
								<img id="verifyCode" src="<c:url value='/VerifyCodeServlet' />" border="1" >
								<a href="javascript:_change()">换一张</a>
							</div>
							<div class="contact2" >${errors.verifyCode }</div>
						</div>
						<div class="form_row">
							<input type="submit" class="register" value="登陆" />
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