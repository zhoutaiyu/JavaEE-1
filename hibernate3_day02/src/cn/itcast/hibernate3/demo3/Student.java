package cn.itcast.hibernate3.demo3;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private Integer sid;
	private String sname;
	// 一个学生可以选择多门课程
	private Set<Course> courses = new HashSet<Course>();

	public Student() {
		super();
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", courses="
				+ courses + "]";
	}

}
