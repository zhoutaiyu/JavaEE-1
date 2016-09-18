<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'upload.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<s:debug />
	<s:fielderror />
	<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="upload"><br>
		<input type="file" name="upload"><br>
		<input type="file" name="upload"><br>
		<input type="submit" value="上传">
	</form>
	<br>
</body>
</html>
