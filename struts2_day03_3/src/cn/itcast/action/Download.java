package cn.itcast.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import cn.itcast.utils.DownloadUtils;

import com.opensymphony.xwork2.ActionSupport;

public class Download extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String filename; // 要下载文件的名称

	@Override
	public String execute() throws Exception {
		System.out.println("进行下载。。。。。。");
		return SUCCESS;
	}

	/**
	 * 用于下载文件流
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public InputStream getInputStream() throws FileNotFoundException,
			UnsupportedEncodingException {

		FileInputStream fis = new FileInputStream(new File("f:/upload",
				filename));
		return fis;
	}

	/**
	 * 得到文件的mimeType类型
	 * 
	 * @return
	 */
	public String getContextType() {
		String mimeType = ServletActionContext.getServletContext().getMimeType(
				filename);
		return mimeType;
	}

	/**
	 * 获得下载文件名
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getDownloadFilname() throws UnsupportedEncodingException {
		return DownloadUtils.getDownloadFileName(ServletActionContext
				.getRequest().getHeader("user-agent"), filename);
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
