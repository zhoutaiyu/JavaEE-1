<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>

<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css">
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
	<table style="width:100; border:0; cellspacing:0; cellpadding:0;">
		<tr>
			<td style="height:12"></td>
		</tr>
	</table>
	<table style="width:100%; border:0;">
		<tr>
			<td>
				<div class="dtree">
					<a href="javascript: d.openAll();">展开所有</a> 
					| <a href="javascript: d.closeAll();">关闭所有</a>
					<script type="text/javascript"
						src="${pageContext.request.contextPath}/js/dtree.js"></script>
					<script type="text/javascript">
						d = new dTree('d');
						d.add(0, -1, '系统菜单树');
						d.add(2, 0, '员工管理', '${pageContext.request.contextPath}/login/welcome.jsp', '', 'mainFrame');

						//子目录添加
						d.add(3, 2, '用户管理', '${pageContext.request.contextPath}/user_findAll', '', 'mainFrame');

						document.write(d);
					</script>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
