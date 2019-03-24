package cn.com.java.classload;

public class Super {

    private static int i =0;

    private int y = 0;

    static {
        System.out.println("Super static{}");
    }

    public Super() {
        System.out.println("Super construction");
        System.out.println("super y : "+y);
    }
}
