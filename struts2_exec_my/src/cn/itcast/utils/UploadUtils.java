package cn.itcast.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

/**
 * 上传工具 <br>
 * 注意：需要引入upload.properties文件
 * 
 * @author 李欣
 * @version 1.0
 *
 */
public class UploadUtils {

	private static Properties props = null;

	private String rootCategory = null; // 上传的根目录

	static {
		try {
			InputStream in = UploadUtils.class.getClassLoader()
					.getResourceAsStream("upload.properties");
			props = new Properties();
			props.load(in);
			in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public UploadUtils(String rootCategory) {
		super();
		this.rootCategory = rootCategory;
	}

	/**
	 * 在文件名前加UUID <br>
	 * 例如：张三.txt -> E0707B50211541DD9F47E2F52E9C45B3_张三.txt
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static String getUuidFileName(String fileName) {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()
				+ "_" + fileName;
	}

	/**
	 * 去除文件名前的UUID <br>
	 * <br>
	 * 例如：E0707B50211541DD9F47E2F52E9C45B3_张三.txt -> 张三.txt
	 * 
	 * @param uuidFileName
	 *            含有uuid的文件名
	 * @return
	 */
	public static String getOriginalFileName(String uuidFileName) {
		return uuidFileName.substring(33);
	}

	/**
	 * 获得上传的根目录 <br>
	 * <br>
	 * 例如：F:/upload
	 * 
	 * @return
	 */
	public String getUploadRootCategory() {
		return props.getProperty(rootCategory);
	}

	/**
	 * 获得hash打散目录 <br>
	 * <br>
	 * 例如：/b/e
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static String getHashCatalog(String fileName) {
		int hCode = fileName.hashCode();// 获取文件名的hashCode

		// 获取hCode的低4位，并转换成16进制字符串
		String dir1 = Integer.toHexString(hCode & 0xF);
		// 获取hCode的低5~8位，并转换成16进制字符串
		String dir2 = Integer.toHexString(hCode >>> 4 & 0xF);

		return "/" + dir1 + "/" + dir2;
	}

	/**
	 * 通过含有UUID的文件名获得获得文件Hash打散的相对路径 <br>
	 * <br>
	 * 例如：E0707B50211541DD9F47E2F52E9C45B3_张三.txt -> <br>
	 * /b/e/E0707B50211541DD9F47E2F52E9C45B3_张三.txt
	 * 
	 * @param uuidFileName
	 *            含有uuid的文件名
	 * @return
	 */
	public static String getRelativePath(String uuidFileName) {
		String originalFileName = getOriginalFileName(uuidFileName);
		String hashCatalog = getHashCatalog(originalFileName);
		return hashCatalog + "/" + uuidFileName;
	}

	/**
	 * 上传文件
	 * 
	 * @param srcFile
	 *            需要上传的文件
	 * @param uuidFileName
	 *            含有UUID的文件名
	 * @throws IOException
	 */
	public void upload(File srcFile, String uuidFileName) throws IOException {
		String uploadRootCategory = getUploadRootCategory(); // 获得上传根目录
		String uploadRelativePath = getRelativePath(uuidFileName); // 获得上传相对路径

		File destFile = new File(uploadRootCategory + uploadRelativePath); // 目标文件
		FileUtils.copyFile(srcFile, destFile); // 上传文件
	}

	/**
	 * 通过相对路径删除文件
	 * 
	 * @param relativePath
	 *            相对路径
	 */
	public boolean deleteByRelativePath(String relativePath) {
		String uploadCategory = getUploadRootCategory(); // 获得上传根目录
		return new File(uploadCategory + relativePath).delete();
	}

	public String getRootCategory() {
		return rootCategory;
	}

	public void setRootCategory(String rootCategory) {
		this.rootCategory = rootCategory;
	}

}
