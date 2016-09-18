package cn.itcast.user.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userID; // ID
	private String userName; // 用户姓名
	private String loginName; // 登录名
	private String loginPwd; // 密码
	private String sex; // 性别（例如：男，女）
	private String birthday; // 出生日期
	private String education; // 学历（例如：研究生、本科、专科、高中）
	private String telephone; // 电话
	private String interest; // 兴趣爱好（例如：体育、旅游、逛街）
	private String path; // 上传路径（path路径）
	private String filename; // 上传文件名称（文件名）
	private String remark; // 备注

	// 数据库中不含有
	private String isUpload; // 是否上传

	public User() {
		super();
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", loginName=" + loginName + ", loginPwd=" + loginPwd
				+ ", sex=" + sex + ", birthday=" + birthday + ", education="
				+ education + ", telephone=" + telephone + ", interest="
				+ interest + ", path=" + path + ", filename=" + filename
				+ ", remark=" + remark + ", isUpload=" + isUpload + "]";
	}

}
