package cn.qdgxy.form.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.qdgxy.form.domain.Product;
import cn.qdgxy.form.service.ProductService;
import cn.qdgxy.util.page.domain.PageBean;

public class ProductServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductService();

	/**
	 * 查找所有
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();

		String page = request.getParameter("page"); // 当前页码
		String rows = request.getParameter("rows"); // 每页显示的数量
		PageBean<Product> pb = productService.findAll(Integer.parseInt(page), Integer.parseInt(rows));

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("total", pb.getTotalRecord()); // 总记录数
		map.put("rows", pb.getBeanList()); // 当前页面中的商品数据

		JSONObject fromObject = JSONObject.fromObject(map);
		writer.print(fromObject);

		writer.close();
		return null;
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = CommonUtils.toBean(request.getParameterMap(), Product.class);
		productService.add(product);
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		productService.delete(Integer.parseInt(pid));
		return null;
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = CommonUtils.toBean(request.getParameterMap(), Product.class);
		productService.edit(product);
		return null;
	}

}
