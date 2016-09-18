package cn.itcast.spring3.demo1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 注解的方式装配Bean
 * 
 * @author 姜涛
 *
 */

@Component("userService")
@Scope
public class UserService {

	// @Autowired
	// @Qualifier("userDao")
	@Resource(name = "userDao")
	private UserDao userDao;

	@Value(value = "itcast")
	private String info;

	public void sayHello() {
		System.out.println("Hello Spring Annotation..." + info);
	}

	@PostConstruct
	public void setup() {
		System.out.println("初始化");
	}

	@PreDestroy
	public void teardown() {
		System.out.println("销毁");
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "UserService [userDao=" + userDao + ", info=" + info + "]";
	}

}
