package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

public class Demo1 {

	/**
	 * 占位符
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun1() throws Exception {
		String str = MessageFormat.format("{1}或{0}", "zhangsan", "123456");
		System.out.println(str);
	}

	/**
	 * 二进制运算导致的误差
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun2() throws Exception {
		System.out.println(2.0 - 1.1); // 0.8999999999999999
	}

	/**
	 * 1000的阶乘
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun3() throws Exception {
		BigInteger sum = new BigInteger("1");
		for (int i = 1; i <= 1000; i++) {
			BigInteger bi = BigInteger.valueOf(i);
			sum = sum.multiply(bi);
		}
		System.out.println(sum);
	}

	/**
	 * BigDecimal 可以处理二进制运算导致的误差
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun4() throws Exception {
		BigDecimal d1 = new BigDecimal("2.0");
		BigDecimal d2 = new BigDecimal("1.1");
		BigDecimal d3 = d1.subtract(d2);
		System.out.println(d3);
	}

	/**
	 * 支付之生成生成hmac
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun5() throws Exception {
		String hmac = PaymentUtil.buildHmac("Buy", "10001126856", "123456",
				"0.01", "CNY", "", "", "",
				"http://localhost:8080/bookstore/OrderServlet?method=back", "",
				"", "ICBC-NET-B2C", "1",
				"69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");
		System.out.println(hmac);
	}

	/**
	 * URL编码
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun6() throws Exception {
		String str = "\"><script>alert('XSS');</script><\"";
		String encode = URLEncoder.encode(str, "UTF-8");
		System.out.println(encode);
		String decode = URLDecoder.decode(encode, "UTF-8");
		System.out.println(decode);
	}

	/**
	 * 正则表达式过滤非法字符\/:*?"<>|&
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun7() throws Exception {
		String regex = "(?=.*[\\/:*?\"<>\\|&]).*";

		String str = "edif";
		String str2 = "\"><script>alert('XSS');</script><\"";

		System.out.println(str.matches(regex));
		System.out.println(str2.replaceAll(regex, ""));

	}

	/**
	 * 转换成html标签
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun8() throws Exception {
		String sql = "1' or '1'='1";
		System.out.println("防SQL注入:" + StringEscapeUtils.escapeSql(sql)); // 防SQL注入

		System.out.println("转义HTML,注意汉字:"
				+ StringEscapeUtils.escapeHtml("<font>chen磊  xing</font>")); // 转义HTML,注意汉字
		System.out.println("反转义HTML:"
				+ StringEscapeUtils
						.unescapeHtml("<font>chen磊  xing</font>  &gt;")); // 反转义HTML

		System.out
				.println("转成Unicode编码：" + StringEscapeUtils.escapeJava("陈磊兴")); // 转义成Unicode编码

		System.out.println("转义XML："
				+ StringEscapeUtils.escapeXml("<name>陈磊兴</name>")); // 转义xml

		System.out.println("反转义XML："
				+ StringEscapeUtils.unescapeXml("<name>陈磊兴</name>")); // 转义xml
	}

	/**
	 * 上传目录hash打散
	 * 
	 * @throws Exception
	 */
	@Test
	public void fun9() throws Exception {
		String name = "swifhsdjkfhsdkjfhsdkjfhdskj_张三.jpg";

		int hCode = name.hashCode();// 获取文件名的hashCode
		// 获取hCode的低4位，并转换成16进制字符串
		String dir1 = Integer.toHexString(hCode & 0xF);
		// 获取hCode的低5~8位，并转换成16进制字符串
		String dir2 = Integer.toHexString(hCode >>> 4 & 0xF);

		System.out.println("hCode:" + hCode);
		System.out.println("dir1:" + dir1);
		System.out.println("dir2:" + dir2);
	}

}
