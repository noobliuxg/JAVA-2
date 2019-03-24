package cn.com.java.mode.command;

public class Bulb implements Electric{
    @Override
    public void runAndStop() {
        System.out.println("Bulb is stop or run");
    }
}
