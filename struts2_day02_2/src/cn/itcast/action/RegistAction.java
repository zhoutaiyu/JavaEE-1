package cn.itcast.action;

import java.util.Arrays;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String[] hobby;
	private int age;
	private Date birthday;

	@Override
	public String execute() throws Exception {
		System.out.println(this);
		return NONE;
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

	@Override
	public String toString() {
		return "RegistAction [username=" + username + ", password=" + password
				+ ", hobby=" + Arrays.toString(hobby) + ", age=" + age
				+ ", birthday=" + birthday + "]";
	}

}
