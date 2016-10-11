<%--
  User: 李欣
  Date: 2016/10/11
  Time: 9:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>程序语言推荐与学习推荐系统</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tiku.css"/>
</head>
<body>
<%-- 页面顶部 --%>
<%@ include file="/WEB-INF/jsps/frame/top.jsp" %>

<div class="content">
    <div id="mainbar">
        <div class="test">
            <h1><b>初中试题</b></h1>
            <div class="test_container">
                <p>
                    <a href="#">语文</a>
                    <a href="#">数学</a>
                    <a href="#">英语</a>
                    <a href="#">物理</a>
                    <a href="#">化学</a>
                    <a href="#">历史</a>
                    <a href="#">政治思品</a>
                    <a href="#">地理</a>
                    <a href="#">生物</a>
                </p>
            </div>
        </div>
        <div class="test">
            <h1><b>高中试题</b></h1>
            <div class="test_container">
                <p>
                    <a href="#">语文</a>
                    <a href="#">数学</a>
                    <a href="#">英语</a>
                    <a href="#">物理</a>
                    <a href="#">化学</a>
                    <a href="#">历史</a>
                    <a href="#">政治思品</a>
                    <a href="#">地理</a>
                    <a href="#">生物</a>
                </p>
            </div>
        </div>
    </div>
    <div class="cl"></div>
</div>

<%-- 页面底部 --%>
<%@ include file="/WEB-INF/jsps/frame/bottom.jsp" %>
</body>
</html>
