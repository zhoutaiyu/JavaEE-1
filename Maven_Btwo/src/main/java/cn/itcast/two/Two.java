package cn.itcast.two;

import cn.itcast.one.One;

public class Two {

	public String say(String name) {
		One one = new One();
		String oneSay = one.say(name);

		return oneSay + " two";
	}

}
