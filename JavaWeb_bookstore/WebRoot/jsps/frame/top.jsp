<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header">
	<div class="logo">
		<a href="<c:url value='/BookServlet?method=findAll' />"><img src="<c:url value='/images/websit/logo.gif' />" alt="" title="" /></a>
	</div>
	<div id="menu">
		<ul>
			<li><a href="<c:url value='/BookServlet?method=findAll' />">主页</a></li>
			<li><a href="<c:url value='/BookServlet?method=findAllSortTime' />">新书畅销</a></li>
			<li><a href="<c:url value='/BookServlet?method=findAll' />">关于我们</a></li>
			<c:choose>
				<c:when test="${empty sessionScope.session_user}">
					<li><a href="<c:url value='/jsps/user/login.jsp'/>">登陆</a></li>
					<li><a href="<c:url value='/jsps/user/regist.jsp'/>">注册</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="<c:url value='/jsps/user_online/user.jsp'/>">个人中心</a></li>
					<li><a href="<c:url value='/OrderServlet?method=myOrders'/>">我的订单</a></li>
					<li><a href="<c:url value='/UserServlet?method=quit' />">退出</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="<c:url value='/BookServlet?method=findAll' />">联系我们</a></li>
		</ul>
	</div>
</div>