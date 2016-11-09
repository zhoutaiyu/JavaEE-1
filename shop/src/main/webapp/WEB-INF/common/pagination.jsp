<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%-- 用于分页 --%>

<div class="pagination">
    <!-- 【首页】 -->
    <a href="<s:property value='pageBean.url' />&pageNumber=1">首页</a>

    <s:if test="pageBean.pageNumber > 1">
        <%-- 【上一页】 --%>
        <a href="<s:property value='pageBean.url' />&pageNumber=<s:property value='pageBean.pageNumber-1' />">
            &lt;&lt;</a>
    </s:if>

    <%-- 计算begin和end --%>
    <%-- 如果页面不足10页，那么显示所有的页面  --%>
    <s:if test="pageBean.totalPage <= 10">
        <s:set var="begin" value="1"/>
        <s:set var="end" value="pageBean.totalPage"/>
    </s:if>
    <s:else>
        <%-- 如果页面大于10页，通过公示计算出begin和end --%>
        <s:set var="begin" value="pageBean.pageNumber-5"/>
        <s:set var="end" value="pageBean.pageNumber+4"/>
        <%-- 头溢出 --%>
        <s:if test="begin < 1">
            <s:set var="begin" value="1"/>
            <s:set var="end" value="10"/>
        </s:if>
        <%-- 尾溢出 --%>
        <s:if test="end > pageBean.totalPage">
            <s:set var="begin" value="pageBean.totalPage - 9"/>
            <s:set var="end" value="pageBean.totalPage"/>
        </s:if>
    </s:else>

    <%-- 循环遍历页码列表 --%>
    <s:iterator var="i" begin="#begin" end="#end">
        <s:if test="#i == pageBean.pageNumber">
            <!-- 【当前页码】 -->
            <span class="currentPage"><s:property value='#i'/></span>
        </s:if>
        <s:else>
            <!-- 【其他页码】 -->
            <a href="<s:property value='pageBean.url' />&pageNumber=<s:property value='#i' />"><s:property
                    value='#i'/></a>
        </s:else>
    </s:iterator>

    <s:if test="pageBean.pageNumber<pageBean.totalPage">
        <!-- 【下一页】 -->
        <a href="<s:property value='pageBean.url' />&pageNumber=<s:property value='pageBean.pageNumber+1' />">
            &gt;&gt;</a>
    </s:if>

    <!-- 【尾页】 -->
    <a href="<s:property value='pageBean.url' />&pageNumber=<s:property value='pageBean.totalPage' />">尾页</a>

    <%-- 第<s:property value='pageBean.pageNumber' />页/共<s:property value='pageBean.totalPage' />页 --%>
</div>