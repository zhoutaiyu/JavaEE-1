package cn.itcast.three;

import cn.itcast.two.Two;

public class Three {

	public String say(String name) {
		Two two = new Two();
		String twoSay = two.say(name);

		return twoSay + " three";
	}

}
