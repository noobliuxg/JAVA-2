package cn.com.java.mode.bridge;

public class BigBrush extends Brush{

    @Override
    public void setPigMent(PigMent pigMent) {
        this.pigMent = pigMent;
    }

    @Override
    public void drawing() {
        System.out.println("使用大型的");
        this.pigMent.color();
        System.out.println("画画");
    }
}
