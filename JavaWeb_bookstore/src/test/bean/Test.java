package test.bean;

import org.apache.commons.lang.StringEscapeUtils;

public class Test {

	/**
	 * 转换成HTML
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return
	 */
	public static String escapeHtml(String str) {
		String regex = "(?=.*[\\/:*?\"<>\\|&]).*"; // 校验是否含有非法字符
		return escapeHtml(str, regex);
	}

	/**
	 * 转换成HTML
	 * 
	 * @param str
	 *            要转换的字符串
	 * @param regex
	 *            查找非法字符的正则表达式
	 * @return
	 */
	public static String escapeHtml(String str, String regex) {
		if (str == null || str.trim().isEmpty()) {
			return "";
		}
		if (str.matches(regex)) {
			return StringEscapeUtils.escapeHtml(str);
		} else {
			return str;
		}
	}
	
}
