<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员管理系统登录</title>

<base target="_top">

<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	function init() {
		document.form1.loginName.focus();
	}
</script>

<style type="text/css">
li {
	list-style: none;
}
</style>
</head>

<body onload="init()">
	<table style="width:100%; height:100%; border:0; cellpadding:0; cellspacing:0;">
		<tr>
			<td align="center">
				<table width="452" height="290" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="#FFFFFF">
							<table width="452" height="290" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td height="74">
										<img src="${pageContext.request.contextPath}/images/logintitle.gif">
									</td>
								</tr>
								<tr>
									<td align="center" valign="bottom" background="${pageContext.request.contextPath}/images/loginbg.gif">
										<s:form id="loginAction_home" name="form1" action="user_login" namespace="/" target="_parent" method="post">
											<table border="0" align="center" cellpadding="2" cellspacing="0">
												<tr align="center">
													<td height="30" colspan="2" style="border-bottom: 1px dotted #cccccc">
														<strong style="font-size: 14px;">请登录</strong>
													</td>
												</tr>
												<tr align="center">
													<td height="30" colspan="2" style="border-bottom: 1px dotted #cccccc">
														<strong style="font-size: 14px; color:red;"><s:actionerror /></strong>
													</td>
												</tr>
												<tr>
													<td height="30" nowrap>
														<font color="000F60"><strong>用户名：</strong> </font>
													</td>
													<td>
														<s:textfield name="loginName" cssClass="text" cssStyle="width: 160px;" />
														<s:fielderror fieldName="loginName" />
													</td>
												</tr>
												<tr>
													<td height="30" nowrap>
														<strong><font color="000F60">密码： </font> </strong>
													</td>
													<td>
														<s:password showPassword="true" name="loginPwd" cssClass="text" cssStyle="width: 160px;" />
														<s:fielderror fieldName="loginPwd" />
													</td>
												</tr>
												<tr>
													<td height="30" nowrap colspan="2">
														<strong><font color="red"></font> </strong>
													</td>
												</tr>
												<tr>
													<td height="30"> </td>
													<td>
														<s:submit name="submit" value="登录" cssClass="buttoninput" />
														<s:reset name="reset" value="取消" cssClass="buttoninput" />
													</td>
												</tr>
											</table>
										</s:form>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>

