package cn.qdgxy.shop.utils.mail;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * 发送邮件工具类
 * 注意添加email.properties文件
 *
 * @author 李欣
 */
public class WebMailUtil {

    private static Properties props = null;

    static {
        try {
            InputStream in = WebMailUtil.class.getClassLoader()
                    .getResourceAsStream("email.properties");
            props = new Properties();
            props.load(new InputStreamReader(in, "UTF-8"));
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 发送邮件
     *
     * @param to   收件人
     * @param code 激活码
     * @throws MessagingException 异常
     */
    public static void sendMail(String to, String code)
            throws MessagingException, IOException {
        // 1. Session对象 与服务器链接
        Session session = MailUtil.createSession(props.getProperty("mail.host"), props.getProperty("username"), props
                .getProperty("password"));

        // 2. 构建邮件信息
        Mail mail = new Mail(props.getProperty("from"), to);
        // 设置主题
        mail.setSubject(props.getProperty("subject"));

        // 设置正文
        String content = props.getProperty("content");
        String ip = props.getProperty("websiteIP");
        String port = props.getProperty("websetPort");
        content = MessageFormat.format(content, ip, port, code, ip, port, code);
        mail.setContent(content);

        // 3. 发送邮件
        MailUtil.send(session, mail);
    }

}
