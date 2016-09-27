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
<title>购物车</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<%-- 公共CSS --%>
<%@ include file="/WEB-INF/jsps/frame/head.jsp"%>

<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css">
</head>

<body>
	<%-- 页面顶部 --%>
	<%@ include file="/WEB-INF/jsps/frame/top.jsp"%>

	<div class="container cart">
	    <div class="span24">
			<s:if test="#session.cart == null || #session.cart.cartItems.size() == 0">
				购物车为空~
			</s:if>
			<s:else>
		        <table>
		            <tbody>
		                <tr>
		                    <th>图片</th>
		                    <th>商品</th>
		                    <th>价格</th>
		                    <th>数量</th>
		                    <th>小计</th>
		                    <th>操作</th>
		                </tr>
		                <s:iterator value="#session.cart.cartItems" var="ci">
			                <tr>
			                    <td width="60"><input type="hidden" name="id" value="22">
			                        <img src="<s:url value='%{#ci.product.image}' />">
			                    </td>
			                    <td>
			                    	<s:url namespace="/" action="product_load" var="productDetailUrl">
		                    			<s:param name="pid" value="#ci.product.pid" />
		                    		</s:url>
		                    	
			                    	<a href="<s:property value="#productDetailUrl"/>" target="_blank">
			                    		<s:property value="#ci.product.pname"/>
			                    	</a>
			                    </td>
			                    <td> ￥<s:property value="#ci.product.shop_price"/> </td>
			                    <td class="quantity" width="60"> 
			                    	<s:property value="#ci.count"/> 
			                    </td>
			                    <td width="140">
			                    	<span class="subtotal">￥<s:property value="#ci.subtotal"/></span>
			                    </td>
			                    <td>
			                    	<a href="${pageContext.request.contextPath}/cart_delete?pid=<s:property value="#ci.product.pid"/> " class="delete">删除</a>
			                    </td>
			                </tr>
		                </s:iterator>
		            </tbody>
		        </table>
		        <dl id="giftItems" class="hidden" style="display: none;"></dl>
		        <div class="total"> 商品金额: <strong id="effectivePrice">￥<s:property value="#session.cart.total"/>元</strong> </div>
		        <div class="bottom"> <a href="<s:url value='/cart_clear'/>" id="clear" class="clear">清空购物车</a> <a href="<s:url value='order_add' />" id="submit" class="submit">提交订单</a> </div>
		    </s:else>
		</div>
	</div>
	
	<%-- 页面底部 --%>
	<%@ include file="/WEB-INF/jsps/frame/bottom.jsp"%>
</body>
</html>
