package cn.itcast.spring3.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class SpringTest1 {

	/**
	 * 传统方式
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		HelloService helloService = new HelloServiceImpl();
		helloService.sayHello();
	}

	@SuppressWarnings("resource")
	@Test
	public void demo2() throws Exception {
		// 工厂类
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloService helloService = (HelloService) applicationContext
				.getBean("userService");
		helloService.sayHello();
	}

	/**
	 * 以前使用BeanFactory
	 * 
	 * @throws Exception
	 */
	@Test
	public void demo4() throws Exception {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));
		HelloService helloService = (HelloService) beanFactory
				.getBean("userService");
		helloService.sayHello();
	}

}
