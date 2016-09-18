<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
<title>商城</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<%-- 公共CSS --%>
<%@ include file="/WEB-INF/jsps/frame/head.jsp"%>

<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<%-- 页面顶部 --%>
	<%@ include file="/WEB-INF/jsps/frame/top.jsp"%>

	<div class="container index">
	    <div class="span24">
	        <div id="hotProduct" class="hotProduct clearfix">
	            <div class="title"> <strong>热门商品</strong> 
	            </div>
	            <ul class="tab">
	                <li class="current"> <a href="#" target="_blank"></a> </li>
	                <li> <a target="_blank"></a> </li>
	                <li> <a target="_blank"></a> </li>
	            </ul>
	            <ul class="tabContent" style="display: block;">
	            	<s:iterator value="hotList" var="hl">
	            		<s:url namespace="/" action="product_load" var="hotProductDetailUrl">
							<s:param name="pid" value="#hl.pid" />
		                </s:url>
		                
		                <li style="cursor:pointer;"> 
		                	<a target="_blank" href="<s:property value="#hotProductDetailUrl"/>">
		                		<img src="${pageContext.request.contextPath}/<s:property value='#hl.image'/>" style="display: block;">
		                	</a>
		                </li>
	                </s:iterator>
	            </ul>
	        </div>
	    </div>
	    <div class="span24">
	        <div id="newProduct" class="newProduct clearfix">
	            <div class="title"> <strong>最新商品</strong> <a  target="_blank"></a> </div>
	            <ul class="tab">
	                <li class="current"> <a href="#" target="_blank"></a> </li>
	                <li> <a target="_blank"></a> </li>
	                <li> <a target="_blank"></a> </li>
	            </ul>
	            <ul class="tabContent" style="display: block;">
	               <s:iterator value="newList" var="nl">
	               		<s:url namespace="/" action="product_load" var="newProductDetailUrl">
							<s:param name="pid" value="#nl.pid" />
		                </s:url>
		                
		                <li style="cursor:pointer;"> 
		                	<a target="_blank" href="<s:property value="#newProductDetailUrl"/>">
		                		<img src="${pageContext.request.contextPath}/<s:property value='#nl.image'/>" style="display: block;">
		                	</a>
		                </li>
	                </s:iterator>
	            </ul>
	        </div>
	    </div>
	    <div class="span24">
	        <div class="friendLink">
	            <dl>
	                <dt>新手指南</dt>
	                <dd> <a href="#" target="_blank">支付方式</a> | </dd>
	                <dd> <a href="#" target="_blank">配送方式</a> | </dd>
	                <dd> <a href="#" target="_blank">售后服务</a> | </dd>
	                <dd> <a href="#" target="_blank">购物帮助</a> | </dd>
	                <dd> <a href="#" target="_blank">蔬菜卡</a> | </dd>
	                <dd> <a href="#" target="_blank">礼品卡</a> | </dd>
	                <dd> <a href="#" target="_blank">银联卡</a> | </dd>
	                <dd> <a href="#" target="_blank">亿家卡</a> | </dd>
	                <dd class="more"> <a href="#" >更多</a> </dd>
	            </dl>
	        </div>
	    </div>
	</div>

	<%-- 页面底部 --%>
	<%@ include file="/WEB-INF/jsps/frame/bottom.jsp"%>
</body>
</html>
