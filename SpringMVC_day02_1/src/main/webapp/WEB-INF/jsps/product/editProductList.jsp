<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>批量修改商品查询</title>
    <script type="text/javascript">
        //修改商品提交
        function updateProduct() {

            //将form的action指向删除商品的地址
            document.productFrom.action = "${pageContext.request.contextPath }/product/editItemsListSubmit.action";

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
                <input type="button" value="批量修改提交" onclick="updateProduct()"/>
            </td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${productList}" var="product" varStatus="s">
            <tr>
                <td><input type="text" name="productList[${s.index }].name" value="${product.name }"/></td>
                <td><input type="text" name="productList[${s.index }].price" value="${product.price }"/></td>
                <td><fmt:formatDate value="${product.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${product.detail }</td>
                <td><a href="${pageContext.request.contextPath }/product/editProduct.action?id=${product.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>

</html>