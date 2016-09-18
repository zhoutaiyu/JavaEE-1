<%@page import="cn.qdgxy.bookstore.admin.domain.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>top</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<style type="text/css">
body{
	background:rgb(111,96,90);
}
</style>
<body>
	<h1 style="text-align: center; ">图书商城后台管理</h1>
	<p style="font-size: 11pt;">
		管理员：${session_admin.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<c:url value='/AdminServlet?method=quit' />" target="_top">退出</a>
	</p>
</body>
</html>
