package cn.qdgxy.shop.utils.mail;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 发送邮件工具类
 * 
 * @author 李欣
 *
 */
public class MailUtils {

	private static Properties props = null;

	static {
		try {
			InputStream in = MailUtils.class.getClassLoader()
					.getResourceAsStream("email.properties");
			props = new Properties();
			props.load(in);
			in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @param to
	 *            收件人
	 * @param code
	 *            激活码
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendMail(String to, String code)
			throws AddressException, MessagingException {
		// 1. Session对象 与服务器链接
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
						props.getProperty("username"), props
								.getProperty("password"));
			}
		});

		// 2. 构建邮件信息
		MimeMessage message = new MimeMessage(session);
		// 发件人
		message.setFrom(new InternetAddress(props.getProperty("from")));
		// 收件人 TO：普通发送 CC:抄送 BCC：密送
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 设置主题
		message.setSubject(props.getProperty("subject"));
		// 设置正文
		String content = props.getProperty("content");
		String ip = props.getProperty("websiteIP");
		String port = props.getProperty("websetPort");
		content = MessageFormat.format(content, ip, port, code, ip, port, code);
		message.setContent(content, "text/html; charset=UTF-8");

		// 3. 发送邮件
		Transport.send(message);
	}

}
