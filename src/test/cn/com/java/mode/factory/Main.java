package cn.com.java.mode.factory;

import cn.com.java.mode.factory.abstractor.AmdFactory;
import cn.com.java.mode.factory.abstractor.Computer;
import cn.com.java.mode.factory.abstractor.IntelFactory;
import cn.com.java.mode.factory.simple.Sender;
import cn.com.java.mode.factory.simple.method.MailSenderFactory;
import cn.com.java.mode.factory.simple.method.SmsSenderFactory;
import cn.com.java.mode.factory.simple.one.SenderEnum;
import cn.com.java.mode.factory.simple.one.SenderFactory;
import org.junit.Test;

public class Main {

    @Test
    public void testOne(){
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.builder(SenderEnum.MAIL);
        sender.send();

        sender = factory.builder(SenderEnum.SMS);
        sender.send();
    }

    @Test
    public void testMore(){
        cn.com.java.mode.factory.simple.more.SenderFactory factory = new cn.com.java.mode.factory.simple.more.SenderFactory();
        Sender sender = factory.buildMail();
        sender.send();
        sender = factory.buildSms();
        sender.send();
    }

    @Test
    public void testMethod(){
        Sender sender = new MailSenderFactory().product();
        sender.send();
        sender = new SmsSenderFactory().product();
        sender.send();
    }

    @Test
    public void testAbstract(){
        Computer computer = new IntelFactory().builder();
        computer.getBoard().print();
        computer.getCpu().print();

        computer = new AmdFactory().builder();
        computer.getCpu().print();
        computer.getBoard().print();
    }
}
