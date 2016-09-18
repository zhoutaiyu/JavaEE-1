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
<base target="_top" href="<%=basePath%>">
<title>管理员登录页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="<c:url value='/js/jquery-1.8.3.min.js' />" ></script>

<script type="text/javascript">
	function _change() {
		var $img = $("#verifyCode");
		$img.attr("src", "VerifyCodeServlet" + "?verfiyCodeTemp="
				+ new Date().getTime());
	}
</script>
</head>

<body>
	<h1>管理员登录页面</h1>
	<hr />
	<p style="font-weight: 900; color: red">${msg }</p>
	<form action="<c:url value='/AdminServlet'/>" method="post">
    <input id="form" type="hidden" name="method" value="login" />
    <table>
    	<tr>
			<td>管理员账户：</td>
			<td><input type="text" name="username" id="username" value="${adm.username}" />${errors.username }<br></td>
		</tr> 
		<tr>
			<td>密　　　码：</td>
			<td><input type="password" name="password" value="${adm.password}"/>${errors.password }<br></td>
		</tr>
		<tr>
			<td>验　证　码：</td>
			<td>
				<input type="text" name="verifyCode" value="${user.verifyCode }" size="3" />
				<img id="verifyCode" src="<c:url value='/VerifyCodeServlet' />" border="1" >
				<a href="javascript:_change()">换一张</a>　　
				${errors.verifyCode }
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="进入后台" /></td>
		</tr>
	</table>
	</form>
	<%-- <a href="javascript:document.getElementById('form').submit();"  target="_top">进入后台</a>--%>
</body>
</html>