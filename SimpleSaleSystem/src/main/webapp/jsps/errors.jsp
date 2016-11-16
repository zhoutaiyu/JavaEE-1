<%--
  User: 李欣
  Date: 2016/11/16
  Time: 17:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>错误页面</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body youdao="bind">
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            请<a href="/login">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
        </ul>
    </div>
</div>

<div class="g-doc">

    <div class="n-result">
        <h3>${msg}</h3>
    </div>
</div>

<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>

<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageIndex.js"></script>

</body>
</html>
