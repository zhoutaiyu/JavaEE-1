package cn.qdgxy.bookstore.book.web.servlet.admin;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;
import cn.qdgxy.bookstore.book.domain.Book;
import cn.qdgxy.bookstore.book.service.BookService;
import cn.qdgxy.bookstore.category.domain.Category;
import cn.qdgxy.bookstore.category.service.CategoryService;

/**
 * 上传图书
 * 
 * @author li119
 *
 */
@WebServlet("/admin/AdminAddBookServlet")
public class AdminAddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 封装表单数据
		// 创建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(30 * 1024,
				new File("F:/f/temp"));
		// 得到解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);

		// 【文件大小校验】
		// 设置单个文件大小为30KB
		sfu.setFileSizeMax(30 * 1024);

		// 使用解析器解析request对象，得到List<FileItem>
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fileItemList = sfu.parseRequest(request);
			// 把fileItemList中的数据封装到book数据中
			// ① 将普通表单数据先封装到map中
			// ② 再将map中的数据封装到book中
			HashMap<String, String> map = new HashMap<String, String>();
			for (FileItem fileItem : fileItemList) {
				if (fileItem.isFormField()) {
					map.put(fileItem.getFieldName(),
							fileItem.getString("UTF-8"));
				}
			}
			Book book = CommonUtils.toBean(map, Book.class);
			// 为book指定bid
			book.setBid(CommonUtils.uuid());
			// 为book设置添加时间
			book.setAddtime(new Date());
			// 为book指定删除状态（未删除）
			book.setDel(false);
			// 将map中的cid封装到category中，再把category给book
			Category category = CommonUtils.toBean(map, Category.class);
			book.setCategory(category);

			// 2. 保存上传的文件（目录和文件名）
			// 得到保存的目录
			String savePath = this.getServletContext().getRealPath(
					"/images/book_img");
			// 得到文件名称
			String fileName = CommonUtils.uuid() + "_"
					+ fileItemList.get(1).getName();

			// 【上传目录hash打散】
			int hCode = fileName.hashCode();// 获取文件名的hashCode
			// 获取hCode的低4位，并转换成16进制字符串
			String dir1 = Integer.toHexString(hCode & 0xF);
			// 获取hCode的低5~8位，并转换成16进制字符串
			String dir2 = Integer.toHexString(hCode >>> 4 & 0xF);
			savePath += "\\" + dir1 + "\\" + dir2;
			new File(savePath).mkdirs(); // 创建不存在的目录(生成的hash目录)

			// 【校验文件扩展名】
			if (!(fileName.toLowerCase().endsWith("jpg")
					|| fileName.toLowerCase().endsWith("png") || fileName
					.toLowerCase().endsWith("gif"))) {
				request.setAttribute("msg", "您上传的图片类型不是jpg, png, 或者gif！");
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
						.forward(request, response);
				return;
			}

			// 创建目标文件（不存在）
			File destFile = new File(savePath, fileName);
			// 保存上传文件到目标文件
			fileItemList.get(1).write(destFile);

			// 3. 设置图片路径（Book对象中的image）
			book.setImage("images/book_img/" + dir1 + "/" + dir2 + "/"
					+ fileName);

			// 4. 使用bookService完成保存
			bookService.add(book);

			// 【校验文件尺寸】
			Image image = new ImageIcon(destFile.getAbsolutePath()).getImage();
			if (image.getWidth(null) > 200 || image.getHeight(null) > 200) {
				destFile.delete(); // 删除文件
				request.setAttribute("msg", "您上传的图片超过200*200！");
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
						.forward(request, response);
				return;
			}

			// 5. 返回图书列表
			request.getRequestDispatcher(
					"/admin/AdminBookServlet?method=findAll").forward(request,
					response);
		} catch (Exception e) {
			if (e instanceof FileSizeLimitExceededException) {
				request.setAttribute("msg", "您上传的文件超过30KB！");
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
						.forward(request, response);
			}
		}
	}

}
