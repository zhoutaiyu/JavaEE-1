package cn.itcast.user.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.itcast.user.domain.User;
import cn.itcast.user.exception.MySQLException;
import cn.itcast.user.service.UserService;
import cn.itcast.utils.DownloadUtils;
import cn.itcast.utils.UploadUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private UploadUtils uploadUtils = new UploadUtils("resumeCategory"); // 上传工具

	private User user = new User(); // 封装用户
	private List<User> users;

	// 上传
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	/**
	 * 登录
	 * 
	 * @return
	 * @throws MySQLException
	 */
	@InputConfig(resultName = "login_input")
	public String login() throws MySQLException {
		User _user = userService.login(user.getLoginName());

		if (_user == null) {
			this.addActionError("用户不存在！");

			return LOGIN;
		} else if (!_user.getLoginPwd().equals(user.getLoginPwd())) {
			this.addActionError("密码错误！");

			return LOGIN;
		}

		ServletActionContext.getRequest().getSession()
				.setAttribute("user", _user);

		return "login_success";
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 * @throws IOException
	 * @throws MySQLException
	 */
	@InputConfig(resultName = "add_input")
	public String add() throws IOException, MySQLException {
		if (upload != null) {
			// 1. 完成上传
			String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
			uploadUtils.upload(upload, uuidFileName);

			// 2. 补全信息
			String uploadRelativePath = UploadUtils
					.getRelativePath(uuidFileName); // 获得上传时的相对路径

			user.setPath(uploadRelativePath);
			user.setFilename(uploadFileName);
		}

		// 3. 调用Service
		userService.add(user);

		return "add_success";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws MySQLException
	 */
	public String delete() throws MySQLException {
		// 查询用户是否有简历
		user = userService.findById(user.getUserID());
		String path = user.getPath();

		// 存在简历则删除
		if (path != null && !path.isEmpty()) {
			uploadUtils.deleteByRelativePath(path);
		}

		userService.delete(user.getUserID());

		return "delete_success";
	}

	/**
	 * 修改前的查询
	 * 
	 * @return
	 * @throws MySQLException
	 */
	public String preEdit() throws MySQLException {
		user = userService.findById(user.getUserID());
		return "preEdit_success";
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws MySQLException
	 * @throws IOException
	 */
	@InputConfig(resultName = "edit_input")
	public String edit() throws MySQLException, IOException {
		if (upload != null) {
			// 员工修改了简历
			// 替换原有简历，数据表修改简历相关信息
			User oldUser = userService.findById(user.getUserID());
			String fileName = oldUser.getFilename();

			// 存在简历则删除
			if (fileName != null && !fileName.isEmpty()) {
				uploadUtils.deleteByRelativePath(fileName);
			}

			// 上传文件
			String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
			uploadUtils.upload(upload, uuidFileName);

			// 补全信息
			String uploadRelativePath = UploadUtils
					.getRelativePath(uuidFileName); // 获得上传时的相对路径

			user.setPath(uploadRelativePath);
			user.setFilename(uploadFileName);

			userService.edit(user, true);
		} else {
			// 员工没有上传 新简历
			// 修改简历之外其他字段
			userService.edit(user, false);
		}

		return "edit_success";
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws MySQLException
	 */
	public String findAll() throws MySQLException {
		users = userService.findAll();

		return "findAll_success";
	}

	/**
	 * 查看个人信息
	 * 
	 * @return
	 * @throws MySQLException
	 */
	public String findById() throws MySQLException {
		user = userService.findById(user.getUserID());

		return "findById_success";
	}

	/**
	 * 条件查询
	 * 
	 * @return
	 * @throws MySQLException
	 */
	public String listSelect() throws MySQLException {
		users = userService.findBySelect(user);

		return "listSelect_success";
	}

	/**
	 * 下载
	 * 
	 * @return
	 * @throws MySQLException
	 */
	public String download() throws MySQLException {
		user = userService.findById(user.getUserID());

		return "download_success";
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
		String path = user.getPath(); // 获得相对路径

		if (user == null || path == null) {
			return null;
		}

		String uploadCategory = uploadUtils.getUploadRootCategory(); // 获得上传根目录
		File file = new File(uploadCategory + path);

		return new FileInputStream(file);
	}

	/**
	 * 得到文件的mimeType类型
	 * 
	 * @return
	 */
	public String getContextType() {
		if (user == null || user.getFilename() == null) {
			return null;
		}

		return ServletActionContext.getServletContext().getMimeType(
				user.getFilename());
	}

	/**
	 * 获得下载文件名
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getDownloadFilname() throws UnsupportedEncodingException {
		if (user == null || user.getFilename() == null) {
			return null;
		}

		return DownloadUtils.getDownloadFileName(ServletActionContext
				.getRequest().getHeader("user-agent"), user.getFilename());
	}

	@Override
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}
