package cn.itcast.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cn.itcast.utils.UploadUtils;

public class TestUtils {

	/**
	 * 测试获得UUID文件名
	 * 
	 * @throws Exception
	 */
	@Test
	public void TestFileUploadUtils() throws Exception {
		System.out.println(UploadUtils.getUuidFileName("zhangsan.jsp"));
	}

	/**
	 * 测试目录打散
	 * 
	 * @throws Exception
	 */
	@Test
	public void TestGetHashCatalog() throws Exception {
		String fileName = "zhangsan.jpg";
		String hashCatalog = UploadUtils.getHashCatalog(fileName);
		System.out.println(hashCatalog);
	}

	/**
	 * 测试上传
	 * 
	 * @throws Exception
	 */
	@Test
	public void TestUpload() throws Exception {
		// 源文件
		File srcFile = new File("F:/mylog.log");

		// 目标文件
		String uuidFileName = UploadUtils.getUuidFileName("mylog.log");
		String hashCatalog = UploadUtils.getHashCatalog("mylog.log");
		File destFile = new File("F:/upload" + hashCatalog, uuidFileName);

		System.out.println("getCanonicalPath()：" + destFile.getCanonicalPath());
		System.out.println("getAbsolutePath() ：" + destFile.getAbsolutePath());
		System.out.println("getAbsoluteFile() ：" + destFile.getAbsoluteFile());

		FileUtils.copyFile(srcFile, destFile);
	}

	@Test
	public void testGetOriginalFileName() throws Exception {
		String path = "/b/6/16549E5637744DD987D02F4AE306B42D_张三.txt";
		
		System.out.println(new UploadUtils("resumeCategory").deleteByRelativePath(path));
		
		System.gc();
	}

}
