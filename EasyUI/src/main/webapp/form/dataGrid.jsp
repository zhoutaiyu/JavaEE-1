<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>数据表格</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<!--easyui的各种主题文件-->
<link rel="stylesheet" type="text/css" href="easyui/themes/bootstrap/easyui.css">
<!--easyui的各种图标-->
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">

<!--引入Jquery主文件-->
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<!--引入JqueryEasyUI主文件-->
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

<!-- 国际化 -->
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	function add() {
		$("#dlg").window("open");
	}
		
	function edit() {
			
	}
		
	function del() {
		
	}
	</script>
</head>

<body>
	<!-- Html形式 -->
	<!-- <table class="easyui-datagrid">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'code'">编码</th>   
	            <th data-options="field:'name'">名称</th>   
	            <th data-options="field:'price'">价格</th>   
	        </tr>   
	    </thead>   
	    <tbody>   
	        <tr>   
	            <td>001</td><td>name1</td><td>2323</td>   
	        </tr>   
	        <tr>   
	            <td>002</td><td>name2</td><td>4612</td>   
	        </tr>   
	    </tbody>   
	</table>  --> 
	
	<!-- JS形式 -->
	<!-- <table id="dg"></table>   -->
	
	
	<div id="tb">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add();">新建</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="preEdit();">编辑</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="del();">删除</a>
	</div>
	
	<!-- 混合形式 -->
	<table class="easyui-datagrid" style="width:800px;height:250px"   
	        data-options="url:'ProductServlet?method=findAll', fitColumns:true,singleSelect:true, 
	        pagination:true, pagePosition:'top', toolBar:'#tb'">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'pid',width:100">编码</th>   
	            <th data-options="field:'name',width:100">名称</th>   
	            <th data-options="field:'price',width:100,align:'right'">价格</th>   
	        </tr>   
	    </thead>   
	</table>
	
	<div id="dlg" class="easyui-dialog" style="width:300px; height:200px"
		data-options="buttons:'#btns', closed:true">
		<form action="" id="fm">
			编号：<input type="text" name=""> <br>
			名称：<input type="text" name=""> <br>
			价格：<input type="text" name=""> <br>
		</form>
	</div>
	
	<div id="btns">
		<a href="#" class="easyui-linkbutton" onclick="edit();">保存</a>
		<a class="easyui-linkbutton" onclick="javascript:$('#dlg').window('close');">取消</a>
	</div>
</body>
</html>
