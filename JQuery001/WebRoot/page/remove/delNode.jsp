<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	//http://localhost:8080/jQuery001
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 下面所有的链接前面都加 -->
<base href="<%=basePath%>">

<title>My JSP 'delNode.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	$(function() {
		//remove 删除当前节点以及下面所有的子节点..
		//	$("#wangyunfei").remove();
		//  清空.. 清空当前节点下面的子节点..
		//  $("#wangyunfei").empty();
	})
</script>
</head>

<body>
	<div id="wangyunfei" title="luyu">
		<div>cccc</div>
		<video></video>
	</div>
</body>
</html>
