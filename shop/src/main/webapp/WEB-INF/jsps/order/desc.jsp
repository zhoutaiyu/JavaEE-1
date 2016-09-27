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
<title>订单</title>
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
	        <div class="step step1">
	            <ul>
	                <li>订单号：<s:property value="order.oid" /> </li>
	            </ul>
	        </div>
	        <table>
	            <tbody>
	                <tr>
	                    <th align="center">图片</th>
	                    <th align="center">商品</th>
	                    <th align="center">价格</th>
	                    <th align="center">数量</th>
	                    <th align="center">小计</th>
	                </tr>
	                <s:iterator value="order.orderItems" var="oi">
		                <tr>
		                    <td width="60" align="center">
		                        <img src="${pageContext.request.contextPath}/<s:property value='#oi.product.image' />"/>
		                    </td>
		                    <td align="center">
		                    	<s:url namespace="/" action="product_load" var="productDetailUrl">
									<s:param name="pid" value="#oi.product.pid" />
				                </s:url>
		                    	<a target="_blank" href="<s:property value='#productDetailUrl'/>">
		                        	<s:property value="#oi.product.pname" />
		                        </a>
		                    </td>
		                    <td align="center">
		                    	<s:property value="#oi.product.shop_price" />
		                    </td>
		                    <td align="center"> 
		                    	<s:property value="#oi.count" />
		                    </td>
		                    <td width="140" align="center">
		                    	<span class="subtotal">￥<s:property value="#oi.subtotal" /></span>
		                    </td>
		                </tr>
	                </s:iterator>
	            </tbody>
	        </table>
	        <dl id="giftItems" class="hidden" style="display: none;"></dl>
	        <div class="total"> 
	        	<em id="promotion"></em> 商品金额: <strong id="effectivePrice">￥<s:property value="order.total" />元</strong> 
	        
	        </div>
	        <form id="orderForm" action="<s:url value='/order_pay' />" method="post">
	        	<input type="hidden" name="oid" value="<s:property value='order.oid' />">
	            <div class="span24">
	                <p> 收货地址：
	                	<input name="order.user.addr" type="text" value="<s:property value='order.address' />" style="width:350px" />
						<br>
						收货人&nbsp;&nbsp;&nbsp;：
						<input name="order.user.username" type="text" value="<s:property value='order.name' />" style="width:150px" />
	                    <br>
						 联系方式：
						<input name="order.user.phone" type="text" value="<s:property value='order.phone' />" style="width:150px" />
	                </p>
	                <hr />
	                <p> 选择银行：<br/>
	                    <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>
	                    工商银行 <img src="${pageContext.request.contextPath}/images/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                    <input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>
	                    中国银行 <img src="${pageContext.request.contextPath}/images/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                    <input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>
	                    农业银行 <img src="${pageContext.request.contextPath}/images/bank_img/abc.bmp" align="middle"/> <br/>
	                    <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>
	                    交通银行 <img src="${pageContext.request.contextPath}/images/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                    <input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>
	                    平安银行 <img src="${pageContext.request.contextPath}/images/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                    <input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>
	                    建设银行 <img src="${pageContext.request.contextPath}/images/bank_img/ccb.bmp" align="middle"/> <br/>
	                    <input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>
	                    光大银行 <img src="${pageContext.request.contextPath}/images/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                    <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>
	                    招商银行 <img src="${pageContext.request.contextPath}/images/bank_img/cmb.bmp" align="middle"/> </p>
	                <hr />
	                <p style="text-align:right"> <a href="javascript:document.getElementById('orderForm').submit();"> <img src="${pageContext.request.contextPath}/images/website/finalbutton.gif" width="204" height="51" border="0" /> </a> </p>
	            </div>
	        </form>
	    </div>
	</div>

	<%-- 页面底部 --%>
	<%@ include file="/WEB-INF/jsps/frame/bottom.jsp"%>
</body>
</html>
