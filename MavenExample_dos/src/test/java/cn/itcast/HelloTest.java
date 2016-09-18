package cn.itcast;
import org.junit.Test;
import junit.framework.Assert;

public class HelloTest {
	
	@Test
	public void testSayHello() {
		Hello h = new Hello();
		String res = h.sayHello("Tom");
		
		// ∂œ—‘≤‚ ‘
		Assert.assertEquals("Hello Tom", res);
	}
	
}