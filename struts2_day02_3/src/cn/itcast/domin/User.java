package cn.itcast.domin;

import java.util.Arrays;
import java.util.Date;

public class User {

	private String username;
	private String password;
	private String[] hobby;
	private int age;
	private Date birthday;
	private String email;
	private String url;
	private String phone;

	private String repassword;

	public User() {
		super();
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

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", hobby=" + Arrays.toString(hobby) + ", age=" + age
				+ ", birthday=" + birthday + ", email=" + email + ", url="
				+ url + ", phone=" + phone + ", repassword=" + repassword + "]";
	}

}
