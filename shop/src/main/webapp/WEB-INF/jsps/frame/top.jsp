<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container header">
    <div class="span5">
        <div class="logo"> <a> <img src="${pageContext.request.contextPath}/images/commodity/r___________renleipic_01/logo.gif" alt="青岛工学院"> </a> </div>
    </div>
    <div class="span9">
        <div class="headerAd"> <img src="${pageContext.request.contextPath}/images/commodity/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"> </div>
    </div>
    <div class="span10 last">
        <div class="topNav clearfix">
            <ul>
            	<s:if test="#session.user != null">
	                <li id="headerLogin" class="headerLogin" style="display: list-item;"> 
	               		<a href="#"> <s:property value="#session.user.name"/> </a>| 
	                </li>
	                <li id="headerLogin" class="headerLogin" style="display: list-item;"> 
	               		<a href="${pageContext.request.contextPath}/user_exit"> 退出  </a>
	                </li>
                </s:if>
                <s:else>
                	<li id="headerLogin" class="headerLogin" style="display: list-item;"> <a href="${pageContext.request.contextPath}/user_loginPage">登录</a>| </li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;"> <a href="${pageContext.request.contextPath}/user_registPage">注册</a>| </li>
                </s:else>
                <li> <a>购物指南</a> | </li>
                <li> <a>关于我们</a> </li>
            </ul>
        </div>
        <div class="cart"> <a href="${pageContext.request.contextPath}/cart_cartPage">购物车</a> </div>
        <div class="phone"> 客服热线: <strong>1234/5678910</strong> </div>
    </div>
    <div class="span24">
        <ul class="mainNav">
            <li> <a href="${pageContext.request.contextPath}/index">首页</a> | </li>
            <s:iterator value="#session.categoryList" var="c" status="status">
            	<s:url namespace="/" action="product_findbyCategory" var="categoryDetailUrl">
            		<s:param name="cid" value="#c.cid" />
            	</s:url>
            
            	<s:if test="!#status.last">
           			<li> <a href='<s:property value="#categoryDetailUrl"/>'><s:property value="#c.cname"/></a> | </li>
           		</s:if>
           		<s:else>
           			<li> <a href="<s:property value="#categoryDetailUrl"/>"><s:property value="#c.cname"/></a></li>
           		</s:else>
			</s:iterator>
        </ul>
    </div>
</div>