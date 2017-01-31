<%--
  User: 李欣
  Date: 2016/11/18
  Time: 15:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="header">

    <div class="head">
        <div class="logo">
            <a href="#"> <img src="${path}/img/index/logo.png"></a>
        </div>
        <div class="menu">
            <ul>
                <li><a href="#">练习中心</a></li>
                <li><a href="#">评估报告</a></li>
                <li><a href="#">我的练习</a></li>
            </ul>
        </div>

        <!--<div class="flase_logreg"><a style="border-radius:5px 0 0 5px;" class="logreg_active">登录</a>
            <a style="border-radius:0px 5px 5px 0;"
            >注册</a>
        </div>-->

        <div class="flase_logreg">
            <a style="border-radius:5px 0 0 5px;" class="logreg_active"
               onclick="$.blockUI({message:window.dialog.login_msg,
               css : {top:  ($(window).height()/2-220) + 'px', left: ($(window).width()/2 -237) + 'px',backgroundColor : 'none',position :
            'fixed'}});_czc.push(['_trackEvent', 'ab测试top登录', '弹出登录框', '登录','','']);">
                登录
            </a>

            <a style="border-radius:0 5px 5px 0;"
               onclick="$.blockUI({message:window.dialog.register_msg,
               css : {top:  ($(window).height()/2-220) + 'px',
                        left: ($(window).width()/2 -237) + 'px',backgroundColor : 'none',position :  'fixed'}});_czc.push(['_trackEvent', 'ab测试top注册', '弹出注册框', '注册','','']);">
                注册
            </a>
        </div>

        <!-- <div class="userInfo">
             <div class="user_pullDown">
                 <span class="listShow  user_list_show" style="position:relative;">
                     <a href="#">张三</a>
                     <b class="message_count_init" style="">11</b>
                 </span>

                 <img src="img/index/pullDown_ico.jpg">
                 <ul class="userSelect">
                     <li>
                         <a href="#">考试区域设置</a>
                     </li>
                     <li>
                         <a href="#">修改密码</a>
                     </li>
                     <li class="message_li">
                         <a href="#">消息通知
                             <b class="message_count">11</b>
                         </a>
                     </li>
                     <li><a href="#"> 修改昵称 </a></li>
                     <li><a href="#">退出</a></li>
                 </ul>
             </div>
         </div>-->
    </div>
    <div class="clear"></div>
</div>

<!--顶部动画下拉框-->
<script type="text/javascript">
    $('a.top_wb').on('mouseenter', function () {
        $('div.top_wxtext').hide();
        $('div.top_wbtext').show();
    });

    $('div.top_wbtext').on('mouseleave', function () {
        $(this).hide();
    });

    $('a.top_wx').on('mouseenter', function () {
        $('div.top_wbtext').hide();
        $('div.top_wxtext').show();
    });

    $('div.top_wxtext').on('mouseleave', function () {
        $(this).hide();
    });
</script>