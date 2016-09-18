<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<title>BookStore</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="/jsps/frame/head.jsp"%>
</head>

<body>
<div id="wrap">
	<%-- 页面顶部 --%>
	<%@ include file="/jsps/frame/top.jsp"%>

	<div class="center_content">
		<%-- 页面左边 --%>
	    <div class="left_content">
	        <div class="title">订单编号：${order.oid}</div>
	        <div class="feat_prod_box_details">
	            <table class="cart_table">
	                <tr class="cart_title">
	                    <td>书名</td>
	                    <td>单价</td>
	                    <td>作者</td>
	                    <td>数量</td>
	                    <td>小计</td>
	                </tr>
	                <c:forEach var="orderItem" items="${order.orderItemList}">
		                <tr>
		                    <td>${orderItem.book.bname}</td>
		                    <td>${orderItem.book.price}￥</td>
		                    <td>${orderItem.book.author}</td>
		                    <td>${orderItem.count}</td>
		                    <td>${orderItem.subtotal}￥</td>
		                </tr>
	            	</c:forEach>
	                <tr>
	                	<td><br></td>
	                </tr>
	                <tr>
	                    <td colspan="5" class="pay_td">
							金　　额：${order.total}￥
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="5" class="pay_td">
							成交时间：<fmt:formatDate value="${order.ordertime}" pattern="yyyy-MM-dd HH:mm:ss"/>　 
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="4" class="pay_td">
							　收货人：${session_user.consignee}
	                    </td>
	                    <td><a href="<c:url value='/jsps/user_online/user.jsp'/>">修改</a></td>
	                </tr>
	                <tr>
	                    <td colspan="4" class="pay_td">
							联系手机：${session_user.phone}
	                    </td>
	                    <td><a href="<c:url value='/jsps/user_online/user.jsp'/>">修改</a></td>
	                </tr>
	                <tr>
	                    <td colspan="4" class="pay_td">
							收货地址：${session_user.adress}
	                    </td>
	                    <td><a href="<c:url value='/jsps/user_online/user.jsp'/>">修改</a></td>
	                </tr>
	                <tr>
	                	<td><br></td>
	                </tr>
	                <tr>
	                    <td colspan="5" class="pay_td">
	                        <form method="post" action="<c:url value='/OrderServlet' />" id="form" target="_parent">
	                            <input type="hidden" name="method" value="pay">
	                            <input type="hidden" name="oid" value="${order.oid}">
								选择银行：<br> 
	                            <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked">工商银行 
	                                <img src="images/bank_img/icbc.bmp"  > 
	                            <input type="radio" name="pd_FrpId" value="BOC-NET-B2C">中国银行
	                                <img src="images/bank_img/bc.bmp" ><br>
	                            <input type="radio" name="pd_FrpId" value="ABC-NET-B2C">农业银行
	                                <img src="images/bank_img/abc.bmp" > 
	                            <input type="radio" name="pd_FrpId" value="CCB-NET-B2C">建设银行
	                                <img src="images/bank_img/ccb.bmp" ><br>
	                            <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C">交通银行
	                                <img src="images/bank_img/bcc.bmp" ><br>
	                        </form>
	                    </td>
	                </tr>
	            </table>
	            <a href="javascript:document.getElementById('form').submit();" class="checkout" target="new">付款 &gt;&gt;</a>
	        </div>
			<div class="clear"></div>
	    </div>

		<%-- 页面右边 --%>
		<%@ include file="/jsps/frame/right.jsp"%>
	</div>

	<%-- 页面底部 --%>
	<%@ include file="/jsps/frame/bottom.jsp"%>
</div>
</body>
</html>