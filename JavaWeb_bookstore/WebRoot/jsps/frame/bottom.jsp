<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="footer">
	<div class="left_footer">
		<img src="<c:url value='/images/websit/footer_logo.gif' />" alt="" title="" /><br />
	</div>
	<div class="right_footer">
		<a href="<c:url value='/BookServlet?method=findAll' />">主页</a> 
		<a href="<c:url value='/BookServlet?method=findAll' />">关于我们</a> 
		<a href="<c:url value='/BookServlet?method=findAll' />">服务</a> 
		<a href="<c:url value='/BookServlet?method=findAll' />">隐私政策</a> 
		<a href="<c:url value='/BookServlet?method=findAll' />">联系我们</a>
	</div>
</div>