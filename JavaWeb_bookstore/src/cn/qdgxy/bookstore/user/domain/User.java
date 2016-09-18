package cn.qdgxy.bookstore.user.domain;

/**
 * User的领域对象
 * 
 * @author li119
 *
 */
public class User {

	private String uid; // 用户ID
	private String username; // 用户名
	private String password; // 用户密码
	private String email; // 用户邮箱地址
	private String consignee; // 收货人姓名
	private String phone; // 手机
	private String adress; // 地址
	private String code; // 激活码
	private boolean state; // 激活状态
	private String verifyCode; // 验证码

	public User() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", email=" + email + ", consignee=" + consignee
				+ ", phone=" + phone + ", adress=" + adress + ", code=" + code
				+ ", state=" + state + ", verifyCode=" + verifyCode + "]";
	}

}
