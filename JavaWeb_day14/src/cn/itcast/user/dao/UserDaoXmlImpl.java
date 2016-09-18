package cn.itcast.user.dao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.itcast.user.domain.User;

/**
 * 针对XML的数据类
 * 
 * @author li119
 *
 */
public class UserDaoXmlImpl implements UserDao {

	// 依赖数据文件
	private static String PATH = "F:/users.xml";

	/**
	 * 按用户名查询
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		/*
		 * 1. 得到Document 
		 * 2. xpath查询
		 *   3. 校验查询结果是否为null，如果为null返回null 
		 *   4.如果不为null，需要将Element对象封装到User
		 * 
		 */

		/*
		 * 1. 得到Document
		 */
		// 创建解析器
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(PATH);
			/*
			 * 2. 通过xpath查询得到Element
			 */
			Element ele = (Element) doc.selectSingleNode("//user[@username='"
					+ username + "']");
			/*
			 * 3. 校验ele是否为null，如果为null返回null
			 */
			if (ele == null) {
				return null;
			}
			/*
			 * 把ele的数据封装到User对象中
			 */
			User user = new User();
			String attrUsername = ele.attributeValue("username");
			String attrPassword = ele.attributeValue("password");
			user.setUsername(attrUsername);
			user.setPassword(attrPassword);
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(User user) {
		/*
		 * 1. 得到Document 
		 * 2. 得到Document得到root元素
		 * 3. 使用参数user，转换成Element对象
		 * 4. 把Element添加到root元素中 5. 保存Document
		 * 
		 */

		// 创建解析器
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(PATH);
			// 得到根元素
			Element root = doc.getRootElement();
			// 通过根元素添加新元素
			Element userEle = root.addElement("user");
			// 为userEle设置属性
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());
			/*
			 * 保存文档
			 */
			// 创建输出格式化器
			OutputFormat format = new OutputFormat("\t", true);// 缩进使用\t,是否换行，是！
			format.setTrimText(true);// 清除原有换行缩进
			// 创建XMLWriter
			XMLWriter writer = new XMLWriter(
					new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(PATH), "utf-8")), format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
