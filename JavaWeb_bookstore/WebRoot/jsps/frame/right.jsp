<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="right_content">
	<div class="cart">
		<div class="title">
			<span class="title_icon">
				<a href="<c:url value='/jsps/cart/list.jsp'/>"><img src="<c:url value='/images/websit/cart.gif' />" alt="" title="" /></a>
			</span> <a href="<c:url value='/jsps/cart/list.jsp'/>">购物车</a>
		</div>
		<div class="home_cart_content">
			<span id="cartBookNumber"></span>本书 | <span class="red">共计: <span id="cartTotalMoney"></span>￥</span>
		</div>
	</div>

	<div class="title">
		<span class="title_icon"><img src="<c:url value='/images/websit/bullet3.gif' />" alt="" title="" /></span>关于我们
	</div>
	<div class="about">
		<p>
			<img src="<c:url value='/images/websit/about.gif' />" alt="" title="" class="right" />
			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
			eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
			ad minim veniam, quis nostrud.
		</p>
	</div>
	<div class="right_box">
		<div class="title">
			<span class="title_icon"><img src="<c:url value='/images/websit/bullet5.gif' />" alt="" title="" /></span>分类
		</div>
		<ul class="list" id="clategoryUl"></ul>
	</div>
	<%-- 作者
		<div class="right_box">
			<div class="title">
				<span class="title_icon"><img src="<c:url value='/images/websit/bullet6.gif' />" alt="" title="" /></span>作者
			</div>
			<ul class="list">
				<li><a href="#">accesories</a></li>
				<li><a href="#">books gifts</a></li>
			</ul>
		</div>
	--%>
</div>
<div class="clear"></div>