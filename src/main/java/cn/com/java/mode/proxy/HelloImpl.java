package cn.com.java.mode.proxy;

public class HelloImpl implements Hello{

    @Override
    public void println() {
        System.out.println("helloImpl");
    }
}
