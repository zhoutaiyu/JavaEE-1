<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>json测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">

        //请求json响应json
        function requestJson() {
            $.ajax({
                url: "${pageContext.request.contextPath}/requestJson.action",
                type: "post",
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                //请求json数据,使用json表示商品信息
                data: '{"name":"手机", "price":1999}',
                success: function (data) {
                    alert(data.name);
                }
            });
        }

        //请求key/value响应json
        function responseJson() {
            $.ajax({
                url: "${pageContext.request.contextPath }/responseJson.action",
                type: "post",
                dataType: "json",
                //contentType:"application/json;charset=utf-8",
                //请求key/value数据
                data: "name=手机&price=1999",
                success: function (data) {
                    alert(data.name);
                }
            });
        }
    </script>
</head>
<body>
<input type="button" value="请求json响应json" onclick="requestJson()"/>
<input type="button" value="请求key/value响应json" onclick="responseJson()"/>
</body>
</html>