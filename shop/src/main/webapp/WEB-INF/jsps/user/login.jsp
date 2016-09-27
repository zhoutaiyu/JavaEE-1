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
<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<%-- 公共CSS --%>
<%@ include file="/WEB-INF/jsps/frame/head.jsp"%>

<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	//改变验证码
	function changeVerifyCode() {
		var $img = $("#verifyCodeImage");
		$img.attr("src", "${pageContext.request.contextPath}/verifyCodeAction?date=" + new Date().getTime());
	}
</script>
</head>

<body>
	<%-- 页面顶部 --%>
	<%@ include file="/WEB-INF/jsps/frame/top.jsp"%>

	<div class="container login">
	    <div class= "span12">
	        <div class="ad">
	        	<img src="${pageContext.request.contextPath}/images/commodity/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">
	        </div>
	    </div>
	    <div class="span12 last">
	        <div class="wrap">
	            <div class="main">
	                <div class="title"> <strong>会员登录</strong>USER LOGIN </div>
	                <form id="loginForm" action="${pageContext.request.contextPath}/user_login" method="post">
	                    <table>
	                        <tbody>
	                        	<tr>
	                                <td colspan="2" align="center" style="color:red;"><s:property value="msg"/></td>
	                            </tr>
	                            <tr>
	                                <th> 用户名: </th>
	                                <td>
	                                	<input type="text" id="username" name="username" class="text" maxlength="20" value="<s:property value="username" />">
	                                	<span> <s:fielderror fieldName="username" /> </span>	
	                                </td>
	                            </tr>
	                            <tr>
	                                <th> 密　码: </th>
	                                <td>
	                                	<input type="password" id="password" name="password" class="text" maxlength="20">
	                                	<span> <s:fielderror fieldName="password" /> </span>
	                                </td>
	                            </tr>
	                            <tr>
	                                <th> 验证码: </th>
	                                <td>
	                                	<span class="fieldSet">
	                                        <input type="text" id="verifyCode" name="verifyCode" class="text captcha" maxlength="4" >
	                                        <img id="verifyCodeImage" class="verifyCodeImage" src="${pageContext.request.contextPath}/verifyCodeAction"
	                                        	title="点击更换验证码" onclick="changeVerifyCode()" style="cursor:pointer;"> 
	                                    </span>
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>&nbsp; </th>
	                                <td>
	                                	<label>
	                                        <input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true">
											 记住用户名 
	                                     </label>
	                                    <label> &nbsp;&nbsp;<a>找回密码</a> </label></td>
	                            </tr>
	                            <tr>
	                                <th>&nbsp; </th>
	                                <td><input type="submit" class="submit" value="登 录"></td>
	                            </tr>
	                            <tr class="register">
	                                <th>&nbsp; </th>
	                                <td>
	                                	<dl>
	                                        <dt>还没有注册账号？</dt>
	                                        <dd> 立即注册即可体验在线购物！ <a href="${pageContext.request.contextPath}/user_registPage">立即注册</a> </dd>
	                                    </dl>
	                               </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>

	<%-- 页面底部 --%>
	<%@ include file="/WEB-INF/jsps/frame/bottom.jsp"%>
</body>
</html>
