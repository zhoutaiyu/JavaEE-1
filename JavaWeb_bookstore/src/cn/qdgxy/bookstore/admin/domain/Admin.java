package cn.qdgxy.bookstore.admin.domain;

public class Admin {

	private String aid; // ID
	private String username; // 用户名
	private String password; // 密码

	public Admin() {
		super();
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
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

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", username=" + username + ", password="
				+ password + "]";
	}

}
