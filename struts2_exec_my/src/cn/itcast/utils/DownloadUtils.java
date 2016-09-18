package cn.itcast.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;

public class DownloadUtils {

	/**
	 * 获得下载文件名 <br>
	 * 解决不同浏览器下载中文文件名乱码问题
	 * 
	 * @param agent
	 *            http协议中请求头中的User-Agent
	 * @param fileName
	 *            文件名
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getDownloadFileName(String agent, String fileName)
			throws UnsupportedEncodingException {
		if (agent.contains("MSIE")) {
			// IE浏览器
			fileName = URLEncoder.encode(fileName, "utf-8");

		} else if (agent.contains("Firefox")) {
			// 火狐浏览器
			BASE64Encoder base64Encoder = new BASE64Encoder();
			fileName = "=?utf-8?B?"
					+ base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
		} else {
			// 其它浏览器
			fileName = URLEncoder.encode(fileName, "utf-8");
		}

		return fileName;
	}

}
