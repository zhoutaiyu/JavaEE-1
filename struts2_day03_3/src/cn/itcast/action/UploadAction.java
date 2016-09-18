package cn.itcast.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// 上传需要声明三个属性
	private List<File> upload; // 表单中name值
	private List<String> uploadContentType;
	private List<String> uploadFileName;

	@Override
	public String execute() throws Exception {
		for (int i = 0; i < upload.size(); i++) {
			System.out.println("上传文件的名称：" + uploadFileName.get(i));
			System.out.println("上传文件的类型：" + uploadContentType.get(i));

			// 完成上传
			FileUtils.copyFile(upload.get(i), new File("f:/upload",
					uploadFileName.get(i)));
		}

		return NONE;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}
