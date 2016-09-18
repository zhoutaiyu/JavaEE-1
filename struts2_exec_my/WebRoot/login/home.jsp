<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>人员管理系统</title>

<style>
body {
	SCROLLBAR-ARROW-COLOR: #ffffff;
	SCROLLBAR-BASE-COLOR: #dee3f7;
}
</style>
</head>

<frameset rows="103,*,43" border="0" framespacing="0">
	<frame src="${pageContext.request.contextPath}/login/top.jsp" name="topFrame" scrolling="NO" noresize="noresize">

	<frameset cols="159,*" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath}/login/left.jsp" name="leftFrame" noresize scrolling="YES">
		<frame src="${pageContext.request.contextPath}/login/welcome.jsp" name="mainFrame">
	</frameset>

	<frame src="${pageContext.request.contextPath}/login/bottom.jsp" name="bottomFrame" scrolling="NO" noresize>
</frameset>
</html>
