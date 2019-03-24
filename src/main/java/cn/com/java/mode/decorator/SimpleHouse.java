package cn.com.java.mode.decorator;

public class SimpleHouse implements House{

    @Override
    public void stop() {
        System.out.print("房子是能为人们遮风挡雨的");
    }
}
