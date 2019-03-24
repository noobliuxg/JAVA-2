package cn.com.java.mode.bridge;

import org.junit.Test;

public class Main {

    @Test
    public void test(){
        Brush brush = new BigBrush();
        PigMent pigMent = new RedPigMent();
        brush.setPigMent(pigMent);
        brush.drawing();
        brush.setPigMent(new BluePigMent());
        brush.drawing();
    }
}
