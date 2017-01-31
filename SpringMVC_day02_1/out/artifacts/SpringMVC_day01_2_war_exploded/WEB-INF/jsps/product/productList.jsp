<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>

    <script type="text/javascript">
        function deleteItems() {
            //将form的action指向删除商品的地址
            document.productFrom.action = "${pageContext.request.contextPath }/product/deleteProduct";

            //进行form提交
            document.productFrom.submit();
        }
    </script>
</head>
<body>
<form name="productFrom" action="${pageContext.request.contextPath}/product/queryItem.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>
                商品类别：
                <select>
                    <c:forEach items="${productType}" var="product">
                        <option value="${product.key}"> ${product.value} </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="查询"/>
                <input type="button" value="批量删除" onclick="deleteItems()"/>
            </td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td><input type="checkbox" name="delete_id" value="${product.id}"/></td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td><fmt:formatDate value="${product.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${product.detail}</td>
                <td><a href="${pageContext.request.contextPath }/product/editProduct?id=${product.id}">修改</a></td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>

</html>