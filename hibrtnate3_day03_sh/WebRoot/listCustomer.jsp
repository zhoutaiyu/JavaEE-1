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
<title>客户列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
function showDetails(cid) {
	var $but = $("#but" + cid); // 按钮
	var $tab = $("#tab" + cid);	// 从服务器获得的数据所要显示的表
	
	if ($but.text() == "订单详情") {
		$.getJSON(
			"${pageContext.request.contextPath}/order_findById?",
			{"cid":cid, "date":new Date().getTime()},
			function callback(data) {
				var tabHtml = "";
				
				for(var i in data) {
					var order = data[i];
					
					if (i == 0) {
						tabHtml +="<tr align='center' style='font-weight:bold;'><td>编号</td><td>地址</td></tr>"
					}
					
					tabHtml +="<tr align='center'><td>" + order.oid + "</td><td>" + order.address + "</td></tr>"
				}
				
				$tab.html(tabHtml);
			}
		);
		
		$but.text("关闭");
	} else {
		$tab.html("");
		$but.text("订单详情");
	}
}
</script>
</head>

<body>
	
	<table border="1" width="600" align="center" cellspacing="0">
		<caption>显示客户列表</caption>
		<thead>
			<tr align="center" style="font-weight:bold;">
				<td>序号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>操作</td>
			</tr>
		</thead>
		
		<tbody>
			<s:iterator value="customers" var="c" status="status">
				<tr align="center">
					<td><s:property value="%{#status.count}"/></td>
					<td><s:property value="%{#c.cname}"/></td>
					<td><s:property value="%{#c.age}"/></td>
					<td>
						<s:url namespace="/" action="customer_delete" var="deleteUrl">
							<s:param name="cid" value="%{#c.cid}" />
						</s:url>
						
						<s:url namespace="/" action="" var="detailsUrl">
							<s:param name="cid" value="%{#c.cid}" />
						</s:url>
						
						<a href="<s:property value="%{#deleteUrl}"/>">删除</a> | 
						<button id="but<s:property value="%{#c.cid}"/>" onclick="showDetails(<s:property value="%{#c.cid}"/>)">订单详情</button>
						<table id="tab<s:property value="%{#c.cid}"/>" width="100%" border="1" cellspacing="0" align="center">
						</table>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>