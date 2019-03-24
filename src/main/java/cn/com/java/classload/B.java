package cn.com.java.classload;

public class B {

    static {
        System.out.println("B 类中的static{}");
    }

    private static int b_static_field = getBStaticField();

    {
        System.out.println("B 类中的{}");
    }

    private int b_no_static_field = getBNoStaticField();

    public B() {
        System.out.println("B 类的构造函数");
    }

    public static int getBStaticField(){
        System.out.println("B 类中的static属性初始化");
        return 0;
    }

    public int getBNoStaticField(){
        System.out.println("B 类中的非static属性初始化");
        return 0;
    }

}
