<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
    <title>商品详情</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <%-- 公共CSS --%>
    <%@ include file="/WEB-INF/jsps/frame/head.jsp" %>

    <link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
</head>

<body>
<%-- 页面顶部 --%>
<%@ include file="/WEB-INF/jsps/frame/top.jsp" %>

<div class="container productContent">
    <%-- 页面左侧--%>
    <%@ include file="/WEB-INF/jsps/frame/left.jsp" %>

    <div class="span18 last">
        <div class="productImage">
            <div class="zoomPad">
                <img style="opacity: 1;" title="" class="medium" src="<s:property value="model.image"/>">
                <div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;"
                     class="zoomPup"></div>
                <div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;"
                     class="zoomWindow">
                    <div style="width: 368px;" class="zoomWrapper">
                        <div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div>
                        <div style="width: 0%; height: 0px;" class="zoomWrapperImage">
                            <img src="#"
                                 style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;">
                        </div>
                    </div>
                </div>
                <div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">
                    Loading zoom
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/cart_add" method="post">
            <input type="hidden" name="pid" value="<s:property value='model.pid'/>">
            <div class="name"><s:property value="model.pname"/></div>
            <div class="sn">
                <div>编号：<s:property value="model.pid"/></div>
            </div>
            <div class="info">
                <dl>
                    <dt>商城价:</dt>
                    <dd><strong>￥：<s:property value="model.shop_price"/></strong> 市场价：
                        <del>￥<s:property value="model.market_price"/></del>
                    </dd>
                </dl>
                <dl>
                    <dt></dt>
                    <dd><span> </span></dd>
                </dl>
            </div>
            <div class="action">
                <dl class="quantity">
                    <dt>购买数量:</dt>
                    <dd>
                        <input id="quantity" name="count" value="1" maxlength="4" type="text">
                    </dd>
                    <dd> 件</dd>
                </dl>
                <div class="buy">
                    <input type="submit" id="addCart" class="addCart" value="加入购物车">
                </div>
            </div>
        </form>
        <div id="bar" class="bar">
            <ul>
                <li id="introductionTab"><a href="#introduction">商品介绍</a></li>
            </ul>
        </div>
        <div id="introduction" class="introduction">
            <div><s:property value="model.pdesc"/></div>
        </div>
    </div>
</div>

<%-- 页面底部 --%>
<%@ include file="/WEB-INF/jsps/frame/bottom.jsp" %>
</body>
</html>
