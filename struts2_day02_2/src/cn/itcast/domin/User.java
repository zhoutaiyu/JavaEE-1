package cn.itcast.domin;

import java.util.Arrays;
import java.util.Date;

public class User {

	private String username;
	private String password;
	private String[] hobby;
	private int age;
	private Date birthday;

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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", hobby=" + Arrays.toString(hobby) + ", age=" + age
				+ ", birthday=" + birthday + "]";
	}

}
