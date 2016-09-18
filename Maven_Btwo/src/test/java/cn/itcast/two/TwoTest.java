package cn.itcast.two;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoTest {

	@Test
	public void TestSay() throws Exception {
		Two two = new Two();
		String result = two.say("Tom");
		
		assertEquals("Hello Tom one two", result);
	}

}
