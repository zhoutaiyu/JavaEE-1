package cn.itcast.three;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeTest {

	@Test
	public void testSay() throws Exception {
		Three three = new Three();
		String result = three.say("Tom");

		assertEquals("Hello Tom one two three", result);
	}

}
