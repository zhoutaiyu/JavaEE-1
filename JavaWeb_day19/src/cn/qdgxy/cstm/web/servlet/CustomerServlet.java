package cn.qdgxy.cstm.web.servlet;

import java.io.IOException;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.cstm.domain.Customer;
import cn.qdgxy.cstm.domain.PageBean;
import cn.qdgxy.cstm.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web层
 * 
 * @author li119
 *
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerService();
	
	/**
	 * 添加客户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Customer对象
		 * 2. 补全：cid，使用uuid
		 * 3. 使用service方法完成添加工作
		 * 4. 向request域中保存成功信息
		 * 5. 转发到msg.jsp
		 */
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		c.setCid(CommonUtils.uuid());
		customerService.add(c);
		request.setAttribute("msg", "添加客户成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 查询所有客户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
//	public String findAll(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		/*
//		 * 1. 调用service得到所有客户
//		 * 2. 保存到request域
//		 * 3. 转发到list.jsp
//		 */
//		request.setAttribute("cstmList", customerService.findAll());
//		return "f:/list.jsp";
//	}
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 获取页面传递的pc
		 * 2. 给定ps的值
		 * 3. 使用pc和ps调用service方法，得到PageBean，保存到request域
		 * 4. 转发到list.jsp
		 */
		int pc = this.getPc(request);	//得到pc
		int ps = 10;	//给定ps的值，第页10行记录
		PageBean<Customer> pb = customerService.findAll(pc, ps);
		
		// 设置URL
		pb.setUrl(this.getUrl(request));
		
		request.setAttribute("pb", pb);
		return "f:/list.jsp";
	}
	
	/**
	 * 获取pc
	 * 
	 * @param request
	 * @return
	 */
	private int getPc(HttpServletRequest request){
		/*
		 * 1. 得到pc
		 *   如果pc参数不存在，说明pc=1
		 *   如果pc参数存在，需要转换成int类型即可
		 */
		String value = request.getParameter("pc");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		} 
		return Integer.parseInt(value);
	}
	
	/**
	 * 编辑之前的加载工作
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 获取cid
		 * 2. 使用cid来调用service方法，得到Customer对象
		 * 3. 把Customer保存到request域中
		 * 4. 转发到edit.jsp显示在表单中
		 */
		String cid = request.getParameter("cid");
		Customer cstm = customerService.load(cid);
		request.setAttribute("cstm", cstm);
		return "f:/edit.jsp";
	}
	
	/**
	 * 编辑方法
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到Customer对象中
		 * 2. 调用service方法完成修改
		 * 3. 保存成功信息到request域
		 * 4. 转发到msg.jsp显示成功信息
		 */
		// 已经封装了cid到Customer对象中
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.edit(c);
		request.setAttribute("msg", "编辑客户成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 删除客户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		customerService.delete(cid);
		request.setAttribute("msg", "删除客户成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 高级搜索
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
//	public String query(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		/*
//		 * 1. 封装表单参数到Customer对象中
//		 * 2. 调用dao方法得到List<Customer>
//		 * 3. 保存到request中
//		 * 4. 转发到list.jsp显示
//		 */
//		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
//		List<Customer> cstmList = customerService.query(criteria);
//		request.setAttribute("cstmList", cstmList);
//		return "f:/list.jsp";
//	}
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 0. 把条件封装到Customer对象中
		 * 1. 得到pc
		 * 2. 给定ps
		 * 3. 使用pc和ps，以及条件对象，调用service方法得到PageBean
		 * 4. 把PageBean保存到request域中
		 * 5. 转发到list.jsp
		 */
		// 获取查询条件
		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		int pc = this.getPc(request);	//得到pc
		int ps = 10;	//给定ps的值，第页10行记录
		PageBean<Customer> pb = customerService.query(criteria, pc, ps);
		pb.setUrl(this.getUrl(request));
		request.setAttribute("pb", pb);
		return "f:/list.jsp";
	}
	
	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String queryString = request.getQueryString();
		
		if (queryString.contains("&pc=")) {
			int index = queryString.indexOf("&pc=");
			queryString = queryString.substring(0, index); 
		}
		
		return contextPath + servletPath + "?" + queryString;
	}
	
}
