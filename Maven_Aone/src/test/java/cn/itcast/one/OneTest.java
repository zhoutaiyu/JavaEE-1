package cn.itcast.one;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneTest {

	@Test
	public void testSay() throws Exception {
		One one = new One();
		String result = one.say("Tom");
		
		assertEquals("Hello Tom one", result);
	}

}
