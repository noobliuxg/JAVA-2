package cn.com.java.mode.factory.simple.one;

import cn.com.java.mode.factory.simple.MailSender;
import cn.com.java.mode.factory.simple.Sender;
import cn.com.java.mode.factory.simple.SmsSender;

public class SenderFactory {
    public Sender builder(SenderEnum senderEnum){
        Sender sender = null;
        switch (senderEnum){
            case SMS:
                sender = new SmsSender();
                break;
            case MAIL:
                sender = new MailSender();
                break;
        }
        return sender;
    }
}
