package cn.com.java.mode.factory.simple;

public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("sms send .....");
    }
}
