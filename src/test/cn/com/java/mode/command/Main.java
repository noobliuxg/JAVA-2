package cn.com.java.mode.command;

import org.junit.Test;

public class Main {

    @Test
    public void test(){
        Electric electric = new Bulb();
        Wire wire = new Wire(electric);
        Button button = new GNButton(wire);
        button.onClick();
    }
}
