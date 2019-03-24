package cn.com.java.mode.facade;

import org.junit.Test;

public class Main {

    @Test
    public void test(){
        Facade facade = new Facade(new FileReader(),new FileWriter(),new CipherMachine());
        System.out.println(facade.cipher("AA"));
    }
}
