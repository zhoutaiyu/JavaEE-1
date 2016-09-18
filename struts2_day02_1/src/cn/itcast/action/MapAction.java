package cn.itcast.action;

import java.util.Map;

import cn.itcast.domin.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 数据封装到map
 * 
 * @author 李欣
 *
 */
public class MapAction extends ActionSupport {

	static final long serialVersionUID = 1L;

	private Map<String, User> map;

	@Override
	public String execute() throws Exception {
		System.out.println(map);
		return NONE;
	}

	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

}
