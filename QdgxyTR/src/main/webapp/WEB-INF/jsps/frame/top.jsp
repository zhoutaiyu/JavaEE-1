<%--
  User: 李欣
  Date: 2016/10/11
  Time: 9:28

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="topbar">
    <div class="content">
        <span class="fl">欢迎来到程序语言推荐与学习推荐系统中心！</span>
        <span class="fr">
            <a href="#" class="toplink" target="_blank">登录</a>
            <a href="#">注册</a>
        </span>
        <span class="cl"></span>
    </div>
</div>
<div id="logo_area"><a href="#"><img src="images/logo.jpg">
    <img src="images/name.jpg" alt="程序语言推荐与学习推荐系统" title="程序语言推荐与学习推荐系统"/></a>
    <div class="search_box">
        <form id="searchform" action="/tiku.php?mod=search" method="post">
            <input type="text" class="search_text search_txt" name="search" id="searchtxt"/>
            <input type="button" class="search_btn"/>
        </form>
    </div>
</div>
<div id="nav">
    <div class="content">
        <ul>
            <li class="current"><a href="#">首页</a></li>
            <li><a href="tiku.php@mod=quest&channel=2&xd=2">初中试题</a></li>
            <li><a href="tiku.php@mod=quest&channel=2&xd=3">高中试题</a></li>
            <li><a href="tiku.php@mod=paper&channel=2&xd=2">初中试卷</a></li>
            <li><a href="tiku.php@mod=paper&channel=2&xd=3">高中试卷</a></li>
        </ul>
    </div>
</div>