package cn.itcast.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.itcast.service.OrderService;
import cn.itcast.vo.Order;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderService();

	private Integer cid; // 用户ID

	/**
	 * 查找用户订单
	 * 
	 * @return
	 * @throws IOException
	 */
	public String findById() throws IOException {
		List<Order> orders = orderService.findById(cid);

		/**
		 * 使用JsonLib转成json数组
		 */
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customer" }); // 去掉customer，否则会有问题
		JSONArray jsonArray = JSONArray.fromObject(orders, jsonConfig);

		// 将数据发送至页面
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(jsonArray);
		
		return NONE;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}
