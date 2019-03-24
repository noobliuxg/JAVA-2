package cn.com.java.mode.factory.simple;

/**
 * 发送邮件
 */
public class MailSender implements Sender{

    @Override
    public void send() {
        System.out.println("mail send .....");
    }
}
