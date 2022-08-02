package firstwork.testyyy;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test01 {

    public static void main(String[] args) {

        String to = "wanyang0626@163.com";

        String from = "1558365217@qq.com";

        // 发件箱qq授权码

        final String pwd = "wapgsykdxuvthdai";

        // 指定发送邮件的主机

        String host = "smtp.qq.com";

        Properties pros = new Properties();

        pros.setProperty("mail.smtp.host", host);

        pros.put("mail.smtp.port", 465);

        pros.put("mail.transport.protocol", "smtp");

        pros.put("mail.smtp.auth", true);

        pros.put("mail.smtp.ssl.enable", "true");

        pros.put("mail.debug", "true");

        // 会话session

        Session session = Session.getDefaultInstance(pros);

        try {

            // 创建默认的消息对象

            MimeMessage message = new MimeMessage(session);

            // 设置头部字段 from to

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // 设置 subject

            message.setSubject("This is the Subject Line!");

            // 消息体

            message.setText("this is actual message,由yyy书写");

            Transport transport = session.getTransport();

            // 连接

            transport.connect(from, pwd);

            // 发送

            transport.sendMessage(message, message.getAllRecipients());

            System.out.println("Sent message successfully...");

        } catch (MessagingException mex) {

            mex.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
