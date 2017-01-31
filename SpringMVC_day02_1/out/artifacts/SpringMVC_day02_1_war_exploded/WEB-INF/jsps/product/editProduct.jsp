<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>修改商品信息</title>

</head>
<body>
<!-- 错误信息 -->
<c:forEach items="${errors}" var="error">
    ${error.defaultMessage}<br/>
</c:forEach>

<form id="productForm" action="${pageContext.request.contextPath }/product/editProductSubmit.action" method="post"
      enctype="multipart/form-data">
    <input type="hidden" name="id" value="${product.id}"/>
    修改商品信息：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${product.name }"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${product.price }"/></td>
        </tr>
        <tr>
            <td>商品生产日期</td>
            <td><input type="text" name="createtime"
                       value="<fmt:formatDate value="${product.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${product.pic !=null}">
                    <img src="/image/${product.pic}" width=100 height=100/>
                    <br/>
                </c:if>
                <input type="file" name="pictureFile"/>
            </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${product.detail }</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>