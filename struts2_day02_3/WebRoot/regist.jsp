<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	<s:fielderror />
	<form action="regist" method="post">
		用户名：<input type="text" name="username">　<s:fielderror fieldName="username" /><br>
		密　码：<input type="password" name="password">　<s:fielderror fieldName="password" /><br>
		密　码：<input type="password" name="repassword">　<br>
		爱　好：<input type="checkbox" name="hobby" value="eat">吃　
			 <input type="checkbox" name="hobby" value="drink">喝　
			 <input type="checkbox" name="hobby" value="play">玩　<br>
		年　龄：<input type="text" name="age">　<s:fielderror fieldName="age" /><br>
		生　日：<input type="text" name="birthday"><br>
		邮　箱:<input type="text" name="email"> <br>
		URL :<input type="text" name="url"> <br>
		手　机:<input type="text" name="phone"> <br>
		<input type="submit" value="提交">
	</form>
	<br>
</body>
</html>
