package cn.qdgxy.bookstore.user.web.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.qdgxy.bookstore.user.domain.User;
import cn.qdgxy.bookstore.util.validation.IllegalStringException;
import cn.qdgxy.bookstore.util.validation.Validation;

/**
 * 用于校验用户输入信息
 * 
 * @author li119
 *
 */
public class UserValidation {

	/**
	 * 校验登陆信息
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	public static Map<String, String> checkLogin(User user,
			HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		checkUsernameOfUser(errors, user);
		checkPasswordOfUser(errors, user);
		checkVerifyCodeOfUser(errors, request);

		return errors;
	}

	/**
	 * 校验注册信息
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	public static Map<String, String> checkRegister(User user,
			HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		checkUsernameOfUser(errors, user);
		checkPasswordOfUser(errors, user);
		checkEmailOfUser(errors, user);
		checkConsigneeOfUser(errors, user);
		checkPhoneOfUser(errors, user);
		checkAdressOfUser(errors, user);
		checkVerifyCodeOfUser(errors, request);

		return errors;
	}

	/**
	 * 校验修改信息
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	public static Map<String, String> checkUpdate(User user,
			HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		checkUsernameOfUser(errors, user);
		checkPasswordOfUser(errors, user);
		checkEmailOfUser(errors, user);
		checkPhoneOfUser(errors, user);
		checkAdressOfUser(errors, user);

		return errors;
	}

	/**
	 * 校验验证码
	 * 
	 * @param errors
	 * @param user
	 */
	private static void checkVerifyCodeOfUser(Map<String, String> errors,
			HttpServletRequest request) {
		String result = Validation.checkVerifyCode(request);
		if (result != null) {
			errors.put("verifyCode", result);
		}
	}

	/**
	 * 校验用户中的用户名
	 * 
	 * @param errors
	 * @param user
	 */
	private static void checkUsernameOfUser(Map<String, String> errors,
			User user) {
		String username = user.getUsername();
		try {
			String result = Validation.checkUsername(username);
			if (result != null) {
				errors.put("username", result); // 保存错误信息
			}
		} catch (IllegalStringException e) { // 含有非法字符， 需要转义，并保存错误信息
			user.setUsername(Validation.escapeHtml(username));
			errors.put("username", e.getMessage());
		}
	}

	/**
	 * 校验用户中的密码
	 * 
	 * @param errors
	 * @param user
	 */
	private static void checkPasswordOfUser(Map<String, String> errors,
			User user) {
		String password = user.getPassword();
		try {
			String result = Validation.checkPassword(password);
			if (result != null) {
				errors.put("password", result); // 保存错误信息
			}
		} catch (IllegalStringException e) { // 含有非法字符， 需要转义，并保存错误信息
			user.setPassword(Validation.escapeHtml(password));
			errors.put("password", e.getMessage());
		}
	}

	/**
	 * 校验用户中的Email
	 * 
	 * @param errors
	 * @param user
	 * @throws IllegalStringException
	 */
	private static void checkEmailOfUser(Map<String, String> errors, User user) {
		String email = user.getEmail();
		try {
			String result = Validation.checkEmail(email);
			if (result != null) {
				errors.put("email", result); // 保存错误信息
			}
		} catch (IllegalStringException e) { // 含有非法字符， 需要转义，并保存错误信息
			user.setEmail(Validation.escapeHtml(email));
			errors.put("email", e.getMessage());
		}
	}

	/**
	 * 校验用户中的收货人
	 * 
	 * @param errors
	 * @param user
	 * @throws IllegalStringException
	 */
	private static void checkConsigneeOfUser(Map<String, String> errors,
			User user) {
		String consignee = user.getConsignee();
		try {
			String result = Validation.checkConsignee(consignee);
			if (result != null) {
				errors.put("consignee", result); // 保存错误信息
			}
		} catch (IllegalStringException e) { // 含有非法字符， 需要转义，并保存错误信息
			user.setConsignee(Validation.escapeHtml(consignee));
			errors.put("consignee", e.getMessage());
		}
	}

	/**
	 * 校验用户中的手机
	 * 
	 * @param errors
	 * @param user
	 * @throws IllegalStringException
	 */
	private static void checkPhoneOfUser(Map<String, String> errors, User user) {
		String phone = user.getPhone();
		try {
			String result = Validation.checkPhone(phone);
			if (result != null) {
				errors.put("phone", result); // 保存错误信息
			}
		} catch (IllegalStringException e) { // 含有非法字符， 需要转义，并保存错误信息
			user.setPhone(Validation.escapeHtml(phone));
			errors.put("phone", e.getMessage());
		}
	}

	/**
	 * 校验用户中的手机
	 * 
	 * @param errors
	 * @param user
	 * @throws IllegalStringException
	 */
	private static void checkAdressOfUser(Map<String, String> errors, User user) {
		String adress = user.getAdress();
		try {
			String result = Validation.checkAdress(adress);
			if (result != null) {
				errors.put("adress", result); // 保存错误信息
			}
		} catch (IllegalStringException e) { // 含有非法字符， 需要转义，并保存错误信息
			user.setAdress(Validation.escapeHtml(adress));
			errors.put("adress", e.getMessage());
		}
	}

}