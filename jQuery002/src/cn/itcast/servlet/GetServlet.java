package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		StringBuffer buffer = new StringBuffer();
		buffer.append("{total:118,rows:[{id:1,title:'左娜'},{id:2,title:'梅斌'},{id:3,title:'酸梅汤'}]}");

		out.println(buffer.toString());
	}

}
