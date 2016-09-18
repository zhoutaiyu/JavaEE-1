package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();

		String imageType = request.getParameter("imageType");
		if ("1".equals(imageType)) {
			out.println("image/1.jpg");
		} else if ("2".equals(imageType)) {
			out.println("image/2.jpg");
		} else if ("3".equals(imageType)) {
			out.println("image/3.jpg");
		} else if ("4".equals(imageType)) {
			out.println("image/4.jpg");
		} else if ("5".equals(imageType)) {
			out.println("image/5.jpg");
		} else if ("6".equals(imageType)) {
			out.println("image/6.jpg");
		}
	}

}
