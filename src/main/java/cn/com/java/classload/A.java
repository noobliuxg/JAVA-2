package cn.com.java.classload;

public class A extends B{
    static {
        System.out.println("A 类中的static{}");
    }

    private static int a_static_field = getAStaticField();

    {
        System.out.println("A 类中的{}");
    }

    private int a_no_static_field = getANoStaticField();

    public A() {
        System.out.println("A 类的构造函数");
    }

    public static int getAStaticField(){
        System.out.println("A 类中的static属性初始化");
        return 0;
    }

    public int getANoStaticField(){
        System.out.println("A 类中的非static属性初始化");
        return 0;
    }
}
