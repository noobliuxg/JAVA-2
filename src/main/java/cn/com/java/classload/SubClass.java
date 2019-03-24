package cn.com.java.classload;


public class SubClass extends Super {

    private static int x = 0;

    private int y = 1;
    static {
        System.out.println("SubClass static{}");
    }

    public SubClass() {
        System.out.println("SubClass construction");
        System.out.println("SubClass y : "+y);
    }
}
