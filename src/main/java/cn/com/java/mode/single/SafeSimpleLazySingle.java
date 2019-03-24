package cn.com.java.mode.single;

public class SafeSimpleLazySingle {
    private static SafeSimpleLazySingle single;

    private SafeSimpleLazySingle(){}

    public static synchronized SafeSimpleLazySingle getInstance(){
        if (single==null){
            single = new SafeSimpleLazySingle();
        }
        return single;
    }
}
