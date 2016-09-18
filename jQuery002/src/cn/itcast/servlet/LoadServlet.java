package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get 方法被调用");
		response.setContentType("text/html");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post 方法被调用");
		response.setContentType("text/html;charset=utf-8");
		System.out.println(request.getParameter("username"));
		PrintWriter out = response.getWriter();

		out.println("<div>您的认证已经成功！</div>");

	}

}
