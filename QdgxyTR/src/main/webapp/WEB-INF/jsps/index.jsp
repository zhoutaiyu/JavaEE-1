<%--
  User: 李欣
  Date: 2016/11/18
  Time: 9:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="frame/head.jsp" %>
</head>
<body>

<%@include file="frame/header.jsp" %>

<div id="content">
    <div class="sl_content">
        <div class="sl_side">
            <div class="sl_title">
                选择科目
            </div>
            <a href="#" class="sl_side_menu active">
                行政能力测试
            </a>

            <a href="#" class="sl_side_menu">
                申论
            </a>

        </div>
        <div class="sl_main">
            <div class="sl_main_bottom">

                <div class="span8">
                    <div class="span8_top">智能推送</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/icon1.png"></div>
                        <div class="right">
                            <div class="rightIntro">告别纸面盲目题海战术，完成所有知识点的覆盖。</div>
                            <a class="spanButton">来二十道</a></div>
                    </div>
                </div>

                <div class="span8">
                    <div class="span8_top">考点直击</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/examPoint.png"></div>
                        <div class="right">
                            <div class="rightIntro">自选考点训练，弱项集中提高，180个考点逐个击破。</div>
                            <a class="spanButton" style="color:#fff;cursor:pointer;">
                                开始练习
                            </a>
                            >
                        </div>
                    </div>
                </div>

                <div class="span8">
                    <div class="span8_top">竞技赛场</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/icon2.png"></div>
                        <div class="right">
                            <div class="rightIntro" style="text-align:left;">知己知彼，方能百战不殆！</div>
                            <a class="spanButton" href="#" style="color:#fff;cursor:pointer;">
                                进入赛场
                            </a>
                            <div class="titleInfoo"></div>
                        </div>
                    </div>
                </div>

                <div class="span8">
                    <div class="span8_top">真题演练</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/icon4.png"></div>
                        <div class="right">
                            <div class="rightIntro">
                                近12年国考，联考，省考及事业单位考试真题，千题百练，祝你成功！
                            </div>
                            <a class="spanButton"
                               href="#"
                               style="color:#fff;cursor:pointer;">
                                选择试卷
                            </a>
                            <div class="titleInfoo"></div>
                        </div>
                    </div>
                </div>

                <div class="span8">
                    <div class="span8_top">万人模考</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/icon8.png"></div>
                        <div class="right">
                            <div class="rightIntro" style="text-align:left;">定期举行全国模考，百万考生同台比拼。</div>
                            <a class="spanButton"
                               href="javascript:xc.module.timing_mock_exercise.select_paper2();"
                               style="color:#fff;cursor:pointer;">
                                万人模考
                            </a>
                            <div class="titleInfoo"></div>
                        </div>
                    </div>
                </div>

                <div class="span8">
                    <div class="span8_top">一起作业吧</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/icon5.png"></div>
                        <div class="right">
                            <div class="rightIntro">跟着老师一起学，一起作业吧！</div>
                            <a class="spanButton gufen" style="color:#fff;cursor:pointer;">
                                做作业
                            </a>
                        </div>
                    </div>
                </div>

                <div class="span8">
                    <div class="span8_top">题目搜索</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/icon3.png"></div>
                        <div class="right">
                            <div class="rightIntro">
                                <input type="text" id="searchInput"
                                       placeholder="请输入题干关键字"
                                       style="width:160px;height:35px; padding-left:2px;line-height:25px;border-radius:5px; margin-left:17px; *margin-left:0;"
                                       onkeypress="xc.module.search.event_handle(this,event)"
                                       onkeydown="xc.module.search.event_handle(this,event)"
                                       maxlength="30"></div>
                            <a class="spanButton gufen" id="question_search"
                               href="#"
                               style="color:#fff;cursor:pointer;">搜索</a>
                        </div>
                    </div>
                </div>

                <div class="span8">
                    <div class="span8_top">精确估分</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/icon6.png"></div>
                        <div class="right">
                            <div class="rightIntro" style="text-align:left;">
                                2016年真题卷详细解析，标准分值，精准预测成绩！<br></div>
                            <a
                                    class="spanButton gufen"
                                    href="http://tiku.huatu.com/cgi-bin/paper.php?appid=1005&amp;action=fetch"
                                    target="_blank" style="color:#fff;cursor:pointer;">
                                开始估分
                            </a>

                        </div>
                    </div>
                </div>

                <div class="span8">
                    <div class="span8_top">定期模考</div>
                    <div class="span8_bottom">
                        <div class="left"><img src="../img/index/icon7.png"></div>
                        <div class="right">
                            <div class="rightIntro" style="text-align:left;">行测全真模拟试卷持续首发...</div>
                            <a class="spanButton"
                               href="javascript:xc.module.timing_mock_exercise.select_paper();"
                               style="color:#fff;cursor:pointer;">
                                定期模考
                            </a>
                            <div class="titleInfoo"></div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="clear"></div>

<%@include file="frame/footer.jsp" %>
</body>
</html>
