package cn.itcast.hibernate3.demo3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

/**
 * 一对多测试
 * 
 * @author 李欣
 *
 */
public class HibernateTest3 {

	private Session session = null;
	private Transaction tx = null;

	/**
	 * 保存学生和课程
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		Student student1 = new Student();
		student1.setSname("张三");

		Student student2 = new Student();
		student2.setSname("李四");

		Course course1 = new Course();
		course1.setCname("JavaSE");

		Course course2 = new Course();
		course2.setCname("JavaEE");

		student1.getCourses().add(course1);
		student1.getCourses().add(course2);
		course2.getStudents().add(student1);
		course2.getStudents().add(student2);

		student2.getCourses().add(course1);
		course1.getStudents().add(student2);

		session.save(student1);
		session.save(student2);
		session.save(course1);
		session.save(course2);
	}

	/**
	 * 级联：保存学生级联课程
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo2() throws Exception {
		Student student = new Student();
		student.setSname("王五");

		Course course = new Course();
		course.setCname("PHP");

		student.getCourses().add(course);
		course.getStudents().add(student);

		session.save(student);
	}

	/**
	 * 级联：删除 多对多很少使用
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo3() throws Exception {
		Student student = session.get(Student.class, 3);

		session.delete(student);
	}

	/**
	 * 学生退课
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo4() throws Exception {
		Student student = session.get(Student.class, 1);
		Course course = session.get(Course.class, 2);

		student.getCourses().remove(course);
	}

	@Before
	public void init() {
		// 1. 创建session
		session = HibernateUtils.openSession();
		// 2. 开启事务
		tx = session.beginTransaction();
	}

	@After
	public void destory() {
		// 3. 提交事务
		tx.commit();
		// 4. 释放资源
		session.close();
	}

}
