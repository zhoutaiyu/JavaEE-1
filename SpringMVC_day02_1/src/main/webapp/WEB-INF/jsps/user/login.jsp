<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登陆</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/login.action">
    用户账号：<input type="text" name="username"/><br/>
    用户密码：<input type="password" name="password"/><br/>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>