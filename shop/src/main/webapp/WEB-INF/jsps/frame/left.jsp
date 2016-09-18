<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="span6">
	<div class="hotProductCategory">
		<s:iterator value="categoryList" var="c">
			<dl>
				<dt>
					<s:url namespace="/" action="product_findbyCategory" var="categoryDetailUrl">
						<s:param name="cid" value="#c.cid" />
					</s:url>

					<%-- 一级分类 --%>
					<a href="<s:property value='#categoryDetailUrl' />"> 
						<s:property value="#c.cname" />
					</a>
				</dt>

				<s:iterator value="#c.categorySeconds" var="cs">
					<dd>
						<s:url namespace="/" action="product_findByCategorySecond" var="categorySecondDetailUrl">
							<s:param name="csid" value="#cs.csid" />
						</s:url>

						<%-- 二级分类 --%>
						<a href="<s:property value='categorySecondDetailUrl' />"> 
							<s:property value="#cs.csname" />
						</a>
					</dd>
				</s:iterator>
			</dl>
		</s:iterator>
	</div>
</div>