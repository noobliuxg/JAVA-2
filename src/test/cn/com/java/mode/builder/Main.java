package cn.com.java.mode.builder;

import org.junit.Test;

public class Main {

    @Test
    public void test(){
        MailBuilder builder = new WageBuiler();
        Director director = new Director();
        director.setMailBuilder(builder);
        Mail mail = director.getMail();
        System.out.println(mail);
    }
}
