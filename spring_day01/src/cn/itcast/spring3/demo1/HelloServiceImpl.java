package cn.itcast.spring3.demo1;

/**
 * 入门案例 实现类
 * 
 * @author 李欣
 *
 */
public class HelloServiceImpl implements HelloService {

	private String info;

	@Override
	public void sayHello() {
		System.out.println("Hello Spring " + info);
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
