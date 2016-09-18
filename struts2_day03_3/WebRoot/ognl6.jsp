<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>演示进行投影操作</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<s:debug />
	<s:property value="ps"/> 
	<hr>
	1. 使用iterator迭代遍历<br>
	<s:iterator value="ps" var="p">
		名称：<s:property value="#p.name"/> <br>
		价格：<s:property value="#p.price"/> <br>
		数量：<s:property value="#p.count"/> <br>
		<hr>
	</s:iterator>
	<hr>
	
	2. 对集合进行投影<br>
	<s:iterator value="ps.{name}" var="pname">
		名称：<s:property value="#pname"/> <br>
	</s:iterator>
	<hr>
	
	3. 将价格大于2000的拿出来<br>
		<s:iterator value="ps.{?#this.price>=2000}" var="p">
		名称：<s:property value="#p.name"/> <br>
		价格：<s:property value="#p.price"/> <br>
		数量：<s:property value="#p.count"/> <br>
		<hr>
	</s:iterator>
	<hr>
	
	4. 将价格大于2000的商品名称<br>
		<s:iterator value="ps.{?#this.price>=2000}.{name}" var="pname">
		名称：<s:property value="#pname"/> <br>
		<hr>
	</s:iterator>
	
	
	
	
	
</body>
</html>
