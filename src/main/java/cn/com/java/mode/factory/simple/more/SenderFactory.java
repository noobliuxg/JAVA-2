package cn.com.java.mode.factory.simple.more;

import cn.com.java.mode.factory.simple.MailSender;
import cn.com.java.mode.factory.simple.Sender;
import cn.com.java.mode.factory.simple.SmsSender;

public class SenderFactory {

    public Sender buildSms(){
        return new SmsSender();
    }

    public Sender buildMail(){
        return new MailSender();
    }
}
