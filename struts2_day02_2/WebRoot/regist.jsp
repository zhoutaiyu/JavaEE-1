<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>My JSP 'regist.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<h1>注册</h1>
	<form action="regist" method="post">
		用户名：<input type="text" name="username"><br>
		密　码：<input type="password" name="password"><br>
		爱　好：<input type="checkbox" name="hobby" value="eat">吃　
			 <input type="checkbox" name="hobby" value="drink">喝　
			 <input type="checkbox" name="hobby" value="play">玩　<br>
		年　龄：<input type="text" name="age"><br>
		生　日：<input type="text" name="birthday"><br>
		<input type="submit" value="提交">
	</form>
	<br>
</body>
</html>
