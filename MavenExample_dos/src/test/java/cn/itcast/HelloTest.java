package cn.itcast;
import org.junit.Test;
import junit.framework.Assert;

public class HelloTest {
	
	@Test
	public void testSayHello() {
		Hello h = new Hello();
		String res = h.sayHello("Tom");
		
		// ���Բ���
		Assert.assertEquals("Hello Tom", res);
	}
	
}