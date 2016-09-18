<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 用于分页 --%>

<%-- 
	 
	<span class="current">1</span> 
	<a href="#?page=2">2</a> 
	<a href="#?page=3">3</a>… 
	<a href="#?page=199">10</a>
	<a href="#?page=200">11</a> 
	<a href="#?page=2">&gt;&gt;</a>
--%>

<div class="pagination">
	<!-- 【首页】 -->
	<a href="${pb.url}&pageNumber=1">首页</a>
	
	<c:if test="${pb.pageNumber>1}">
		<%-- 【上一页】 --%>
		<a href="${pb.url}&pageNumber=${pb.pageNumber-1}">&lt;&lt;</a>
	</c:if>
	
	<%-- 计算begin和end --%>
	<c:choose>
		<%-- 如果页面不足10页，那么显示所有的页面  --%>
		<c:when test="${pb.totalPage<=10}">
			<c:set var="begin" value="1" />
			<c:set var="end" value="${pb.totalPage}" />
		</c:when>
		<c:otherwise>
			<%-- 如果页面大于10页，通过公示计算出begin和end --%>
			<c:set var="begin" value="${pb.pageNumber-5}" />
			<c:set var="end" value="${pb.pageNumber+4}" />
			<%-- 头溢出 --%>
			<c:if test="${begin < 1}">
				<c:set var="begin" value="1" />
				<c:set var="end" value="10" />
			</c:if>
			<%-- 尾溢出 --%>
			<c:if test="${end > pb.totalPage}">
				<c:set var="begin" value="${pb.totalPage - 9}" />
				<c:set var="end" value="${pb.totalPage}" />
			</c:if>
		</c:otherwise>
	</c:choose>
	
	<%-- 循环遍历页码列表 --%>
	<c:forEach var="i" begin="${begin}" end="${end}">
		<c:choose>
			<c:when test="${i eq pb.pageNumber}">
				<!-- 【当前页码】 -->
				<span class="current">${i}</span>
			</c:when>
			<c:otherwise>
				<!-- 【其他页码】 -->
				<a href="${pb.url}&pageNumber=${i}" >${i}</a> 
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${pb.pageNumber<pb.totalPage}">
		<!-- 【下一页】 -->
		<a href="${pb.url}&pageNumber=${pb.pageNumber+1}">&gt;&gt;</a>
	</c:if>
	
	<!-- 【尾页】 -->
	<a href="${pb.url}&pageNumber=${pb.totalPage}">尾页</a>
	
	第${pb.pageNumber}页/共${pb.totalPage}页
</div>