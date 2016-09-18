<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>菜单</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<c:url value='/plugins/menu/mymenu.css'/>" type="text/css" media="all">

<script type="text/javascript" src="<c:url value='/plugins/menu/mymenu.js'/>"></script>

<script language="javascript">
	<%-- 
	参数:
		bar1必须与对象名相同
		图书商城 : 大标题
	--%>
	var bar1 = new Q6MenuBar("bar1", "图书商城");
	function load() {
	<%-- 设置配色方案 配色方案一共四种：0 1 2 3 --%>
	bar1.colorStyle = 2;
	<%-- 指定图片目录：加、减的图片 --%>
	bar1.config.imgDir = "<c:url value='/plugins/menu/img/'/>";
	<%-- 设置菜单之间是否排斥 --%>
	bar1.config.radioButton = true;
	
	<%-- "分类管理" : 指定要添加的菜单名称 --%>
	<%-- "查看分类" : 指定菜单项名称 --%>
	<%-- "<c:url value='/adminjsps/admin/category/list.jsp'/>" :指定菜单项打开的链接 --%>
	<%-- "body" : 指定菜单项显示框架页名称 --%>
	bar1.add("分类管理", "查看分类", "<c:url value='/admin/AdminCategoryServlet?method=findAll'/>", "body");
	bar1.add("分类管理", "添加分类", "<c:url value='/adminjsps/admin/category/add.jsp'/>", "body");

	bar1.add("图书管理", "查看图书", "<c:url value='/admin/AdminBookServlet?method=findAll'/>", "body");
	bar1.add("图书管理", "添加图书", "<c:url value='/admin/AdminBookServlet?method=addPre'/>", "body");

	bar1.add("订单管理", "所有订单", "<c:url value='/admin/AdminOrderServlet?method=findAll'/>", "body");
	bar1.add("订单管理", "未付款订单", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=1'/>", "body");
	bar1.add("订单管理", "已付款订单", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=2'/>", "body");
	bar1.add("订单管理", "未收货订单", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=3'/>", "body");
	bar1.add("订单管理", "已完成订单", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=4'/>", "body");
	
	<%-- 获取显示菜单的div --%>
	var d = document.getElementById("menu");
	<%-- 将菜单转换成字符串，添加到显示的div中 --%>
	d.innerHTML = bar1.toString();
	}
</script>
</head>

<body onload="load()" style="margin: 0px; background: rgb(254,238,189);">
	<div id="menu"></div>
</body>
</html>
