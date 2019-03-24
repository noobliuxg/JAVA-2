package cn.com.java.mode.single;

public class UnSafeLazySingle {
    private static UnSafeLazySingle single = null;

    private UnSafeLazySingle(){}

    public static UnSafeLazySingle getInstance(){
        if (single==null){
            single = new UnSafeLazySingle();
        }
        return single;
    }
}
