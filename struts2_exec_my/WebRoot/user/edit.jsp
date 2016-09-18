<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">

<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/check.js"></script>

<!-- 日期插件，使用jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.4.2.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
</HEAD>

<script type="text/javascript">
	$(document).ready(function() {
		//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
		$('#birthday').datepick({
			dateFormat : 'yy-mm-dd'
		});
	});
</script>

<body>
	<s:form id="userAction_save_do" name="Form1" namespace="/" action="user_edit" method="post" enctype="multipart/form-data">
		<s:hidden name="userID" value="%{model.userID}" />
		<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
					<strong><STRONG>编辑用户</STRONG> </strong>
				</td>
			</tr>
			
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
					<s:fielderror />
				</td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					登录名：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
					<s:textfield name="loginName" value="%{model.loginName}" id="userAction_save_do_loginName" cssClass="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">密码：</td>
				<td class="ta_01" bgColor="#ffffff">
					<s:password name="loginPwd" showPassword="true" value="%{model.loginPwd}" id="loginPwd"  />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">用户姓名：</td>
				<td class="ta_01" bgColor="#ffffff">
					<s:textfield name="userName" value="%{model.userName}" id="userAction_save_do_userName" cssClass="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
				<td class="ta_01" bgColor="#ffffff">
					<s:radio list="{'男', '女'}" name="sex" id="sex" value="%{model.sex}" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">学历：</td>
				<td class="ta_01" bgColor="#ffffff">
					<s:select list="{'博士', '硕士', '研究生', '本科', '专科', '高中', '初中', '小学'}" name="education" id="education"
						headerKey="" headerValue="--选择学历--" value="%{model.education}" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">出生日期：</td>
				<td class="ta_01" bgColor="#ffffff">
					<s:textfield name="birthday" size="20" value="%{model.birthday}" readonly="readonly" id="birthday" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">电话：</td>
				<td class="ta_01" bgColor="#ffffff">
					<s:textfield name="telephone" value="%{model.telephone}" id="telephone" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">兴趣爱好：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<s:checkboxlist list="{'看电影', '旅游', '健身', '购物', '睡觉'}" name="interest" value="" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">简历资料：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
					<s:file name="upload" size="30" id="userAction_save_do_upload" />
				</td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">备注：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
					<s:textarea name="remark" value="%{model.remark}" cols="30" rows="3" id="userAction_save_do_remark" style="WIDTH: 96%" />
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1">
					<img src="${pageContext.request.contextPath}/images/shim.gif">
				</td>
			</TR>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<s:submit value="确定" id="userAction_save_do_submit" name="submit" cssClass="button_ok" />
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					
					<s:reset value="重置" class="button_cancel" />
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> 
					
					<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</HTML>