package cn.com.java.mode.factory.simple.method;

import cn.com.java.mode.factory.simple.Sender;
import cn.com.java.mode.factory.simple.SmsSender;

public class SmsSenderFactory implements Prodiver{
    @Override
    public Sender product() {
        return new SmsSender();
    }
}
