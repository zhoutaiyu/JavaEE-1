package cn.qdgxy.bookstore.util.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * 用于校验信息
 * 
 * @author li119
 *
 */
public class Validation {

	private final static String REGEX = "(?=.*[\\/:*?\"<>\\|&]).*"; // 校验是否含有非法字符

	/**
	 * 校验验证码
	 * 
	 * @param errors
	 * @param user
	 * @throws IllegalStringException
	 */
	public static String checkVerifyCode(HttpServletRequest request) {
		String result = null;
		String verifyCode = request.getParameter("verifyCode");
		String vcode = (String) request.getSession().getAttribute(
				"session_vcode");
		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			result = "验证码不能为空!";
		} else if (verifyCode.matches(REGEX)
				|| !verifyCode.equalsIgnoreCase(vcode)) {
			result = "验证码错误!";
		}
		return result;
	}

	/**
	 * 校验用户名
	 * 
	 * @param errors
	 * @param user
	 * @throws IllegalStringException
	 */
	public static String checkUsername(String username)
			throws IllegalStringException {
		String result = null;
		if (username == null || username.trim().isEmpty()) {
			result = "用户名不能为空!";
		} else if (username.matches(REGEX)) {
			throw new IllegalStringException("用户名中不能含有非法字符\\/:*?\"<>|&");
		} else if (username.length() < 6 || username.length() > 20) {
			result = "用户名的长度为6~20";
		}
		return result;
	}

	/**
	 * 校验密码
	 * 
	 * @param errors
	 * @param user
	 * @throws IllegalStringException
	 */
	public static String checkPassword(String password)
			throws IllegalStringException {
		String result = null;
		if (password == null || password.trim().isEmpty()) {
			result = "密码不能为空!";
		} else if (password.matches(REGEX)) {
			throw new IllegalStringException("密码中不能含有非法字符\\/:*?\"<>|&");
		} else if (password.length() < 6 || password.length() > 20) {
			result = "密码长度必须在6~20之间！";
		}
		return result;
	}

	/**
	 * 校验email
	 * 
	 * @param errors
	 * @param user
	 * @throws IllegalStringException
	 */
	public static String checkEmail(String email) throws IllegalStringException {
		String result = null;
		if (email == null || email.trim().isEmpty()) {
			result = "Email不能为空!";
		} else if (email.matches(REGEX)) {
			throw new IllegalStringException("邮箱名中不能含有非法字符\\/:*?\"<>|&");
		} else if (!email
				.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			result = "Email格式错误！";
		}
		return result;
	}

	/**
	 * 校验收件人
	 * 
	 * @param errors
	 * @param user
	 */
	public static String checkConsignee(String consignee)
			throws IllegalStringException {
		String result = null;
		if (consignee == null || consignee.trim().isEmpty()) {
			result = "收货人不能为空!";
		} else if (consignee.matches(REGEX)) {
			throw new IllegalStringException("收货人中不能含有非法字符\\/:*?\"<>|&");
		}
		return result;
	}

	/**
	 * 校验手机号
	 * 
	 * @param errors
	 * @param user
	 */
	public static String checkPhone(String phone) throws IllegalStringException {
		String result = null;
		if (phone == null || phone.trim().isEmpty()) {
			result = "手机不能为空!";
		} else if (phone.matches(REGEX)) {
			throw new IllegalStringException("手机号中不能含有非法字符\\/:*?\"<>|&");
		} else if (!phone.matches("^[1]([3|7][0-9]{1}|59|58|88|89)[0-9]{8}$")) {
			result = "手机格式错误！";
		}
		return result;
	}

	/**
	 * 校验地址
	 * 
	 * @param errors
	 * @param user
	 */
	public static String checkAdress(String adress)
			throws IllegalStringException {
		String result = null;
		if (adress == null || adress.trim().isEmpty()) {
			result = "地址不能为空!";
		} else if (adress.matches(REGEX)) {
			throw new IllegalStringException("地址中不能含有非法字符\\/:*?\"<>|&");
		}
		return result;
	}

	/**
	 * 校验数字
	 * 
	 * @param errors
	 * @param user
	 */
	public static String checkNumber(String number)
			throws IllegalStringException {
		String result = null;
		if (number == null || number.trim().isEmpty()) {
			result = "不能为空!";
		} else if (number.matches(REGEX)) {
			throw new IllegalStringException("不能含有非法字符\\/:*?\"<>|&");
		} else {
			if (!number.matches("^\\+?[1-9][0-9]*$")) {
				result = "输入错误";
			}
		}
		return result;
	}

	/**
	 * 将字符串转义成HTML
	 * 
	 * @param str
	 * @return
	 */
	public static String escapeHtml(String str) {
		return StringEscapeUtils.escapeHtml(str);
	}

}