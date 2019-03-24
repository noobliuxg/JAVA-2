package cn.com.java.mode.decorator;

import org.junit.Test;

public class Main {

    @Test
    public void test(){
        House exquisite = new Exquisite(new SimpleHouse());
        exquisite.stop();
    }
}
