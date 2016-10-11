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
                    <a href="tiku.php@mod=list&channel=2&xd=2">语文</a>
                    <a href="tiku.php@mod=list&channel=3&xd=2">数学</a>
                    <a href="tiku.php@mod=list&channel=4&xd=2">英语</a>
                    <a href="tiku.php@mod=list&channel=6&xd=2">物理</a>
                    <a href="tiku.php@mod=list&channel=7&xd=2">化学</a>
                    <a href="tiku.php@mod=list&channel=8&xd=2">历史</a>
                    <a href="tiku.php@mod=list&channel=9&xd=2">政治思品</a>
                    <a href="tiku.php@mod=list&channel=10&xd=2">地理</a>
                    <a href="tiku.php@mod=list&channel=11&xd=2">生物</a>
                </p>
            </div>
        </div>
        <div class="test">
            <h1><b>高中试题</b></h1>
            <div class="test_container">
                <p>
                    <a href="tiku.php@mod=list&channel=2&xd=3">语文</a>
                    <a href="tiku.php@mod=list&channel=3&xd=3">数学</a>
                    <a href="tiku.php@mod=list&channel=4&xd=3">英语</a>
                    <a href="tiku.php@mod=list&channel=6&xd=3">物理</a>
                    <a href="tiku.php@mod=list&channel=7&xd=3">化学</a>
                    <a href="tiku.php@mod=list&channel=8&xd=3">历史</a>
                    <a href="tiku.php@mod=list&channel=9&xd=3">政治思品</a>
                    <a href="tiku.php@mod=list&channel=10&xd=3">地理</a>
                    <a href="tiku.php@mod=list&channel=11&xd=3">生物</a>
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
