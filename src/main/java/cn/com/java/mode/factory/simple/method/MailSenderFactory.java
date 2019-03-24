package cn.com.java.mode.factory.simple.method;

import cn.com.java.mode.factory.simple.MailSender;
import cn.com.java.mode.factory.simple.Sender;

public class MailSenderFactory implements Prodiver{
    @Override
    public Sender product() {
        return new MailSender();
    }
}
