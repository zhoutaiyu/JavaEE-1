<%--
  User: lixin
  Date: 2017/5/23
  Time: 14:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <!--引入wangEditor.css-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/wangEditor.min.css">

    <!--引入jquery和wangEditor.js-->   <!--注意：javascript必须放在body最后，否则可能会出现问题-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/lib/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/wangEditor.min.js"></script>
</head>
<body>
<!--用父容器来控制宽度-->
<div style="width:90%">
    <!--用当前元素来控制高度-->
    <div id="div1" style="height:400px;max-height:500px;">
        <p>请输入内容...</p>
    </div>
    <button id="btn1">获取内容</button>
</div>

<!--这里引用jquery和wangEditor.js-->
<script type="text/javascript">
    var editor = new wangEditor('div1');
    // 关闭js过滤
    // editor.config.jsFilter = false;
    editor.create();

    $('#btn1').click(function () {
        // 获取编辑器区域完整html代码
        var html = editor.$txt.html();

        // 获取编辑器纯文本内容
        var text = editor.$txt.text();

        // 获取格式化后的纯文本
        var formatText = editor.$txt.formatText();

        console.log(html);
        console.log(text);
        console.log(formatText);
    });
</script>
</body>
</html>
