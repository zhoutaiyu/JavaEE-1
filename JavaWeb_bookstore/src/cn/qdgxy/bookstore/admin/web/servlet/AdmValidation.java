package cn.qdgxy.bookstore.admin.web.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;

import cn.qdgxy.bookstore.admin.domain.Admin;

/**
 * 用于验证输入的信息
 * 
 * @author qq477
 *
 */
public class AdmValidation {
	private final static String REGEX = "(?=.*[\\/:*?\"<>\\|&]).*"; // 校验是否含有非法字符

	/**
	 * 校验登陆信息
	 * 
	 * @param admin
	 * @param request
	 * @return
	 */
	public static Map<String, String> ValidateLogin(Admin admin,
			HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		String username = admin.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空!");
		} else if (username.matches(REGEX)) {
			admin.setUsername(StringEscapeUtils.escapeHtml(username)); // 防止XSS攻击
			errors.put("username", "用户名中不能含有非法字符\\/:*?\"<>|&");
		} else if (username.length() < 6 || username.length() > 20) {
			errors.put("username", "用户名的长度为6~20");
		}

		String password = admin.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空!");
		} else if (password.matches(REGEX)) {
			admin.setPassword(StringEscapeUtils.escapeHtml(password)); // 防止XSS攻击
			errors.put("password", "密码中不能含有非法字符\\/:*?\"<>|&");
		} else if (password.length() < 6 || password.length() > 20) {
			errors.put("password", "密码长度必须在6~20之间！");
		}

		String verifyCode = request.getParameter("verifyCode");
		String vcode = (String) request.getSession().getAttribute(
				"session_vcode");
		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空!");
		} else if (verifyCode.matches(REGEX)
				|| !verifyCode.equalsIgnoreCase(vcode)) {
			errors.put("verifyCode", "验证码错误!");
		}

		return errors;
	}

}
