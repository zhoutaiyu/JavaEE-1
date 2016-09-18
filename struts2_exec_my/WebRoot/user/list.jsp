<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />

<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>

<script type="text/javascript">
	function addUser() {
		window.location.href = "${pageContext.request.contextPath}/user/add.jsp";
	}
</script>
</HEAD>
<body>
	<s:form id="Form1" name="Form1" action="user_listSelect" namespace="/" method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3">
						<strong>查询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									用户姓名：
								</td>
								<td class="ta_01" bgColor="#ffffff">
									<s:textfield name="userName" size="15" id="Form1_userName" cssClass="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									性别：
								</td>
								<td class="ta_01" bgColor="#ffffff">
									<s:select list="{'男', '女'}" name="sex" id="sex" headerKey="" headerValue="--选择性别--" />
								</td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									学历：
								</td>
								<td class="ta_01" bgColor="#ffffff">
									<s:select list="{'博士', '硕士', '研究生', '本科', '专科', '高中', '初中', '小学'}" name="education" id="education"
										headerKey="" headerValue="--选择学历--" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									是否上传简历：
								</td>
								<td class="ta_01" bgColor="#ffffff">
									<s:select list="#{'1':'有', '0':'无'}" name="isUpload" id="isUpload" headerKey="" headerValue="--请选择--" />
								</td>
							</tr>
							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe" class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff">
									<font face="宋体" color="red"> &nbsp;</font>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<br>
									<br>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<s:submit id="search" name="search" value="查询" cssClass="button_view" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									<s:reset name="reset" value="重置" cssClass="button_view" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3">
						<strong>用户 列 表</strong>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
							&#28155;&#21152;
						</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1" style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="18%">登录名</td>
								<td align="center" width="17%">用户姓名</td>
								<td align="center" width="8%">性别</td>
								<td align="center" width="23%">联系电话</td>
								<td width="11%" align="center">学历</td>
								<td width="7%" align="center">查看</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<s:iterator value="%{users}" var="u">
								<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
										<s:property value="%{#u.loginName}" />
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
										<s:property value="%{#u.userName}" />
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
										<s:property value="%{#u.sex}" />
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="23%">
										<s:property value="%{#u.telephone}"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										<s:property value="%{#u.education}"/>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<s:url namespace="/" action="user_findById" var="findByIdUrl">
											<s:param name="userID" value="%{#u.userID}" />
										</s:url>
										
										<s:a href="%{#findByIdUrl}">
											<img src="${pageContext.request.contextPath}/images/button_view.gif" border="0" style="CURSOR: hand">
										</s:a>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<s:url namespace="/" action="user_preEdit" var="preEditUrl">
											<s:param name="userID" value="%{#u.userID}" />
										</s:url>
										
										<s:a href="%{#preEditUrl}">
											<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
										</s:a>
									</td>
									<td align="center" style="HEIGHT: 22px">
										<%-- <s:a namespace="/" action="user_delete">
											<s:param name="id" value="%{#u.userID}" />
											<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
										</s:a> --%>
										
										<s:url namespace="/" action="user_delete" var="delUrl">
											<s:param name="userID" value="%{#u.userID}" />
										</s:url>
										
										<s:a href="%{#delUrl}">
											<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
										</s:a>
									</td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</s:form>
</body>
</HTML>