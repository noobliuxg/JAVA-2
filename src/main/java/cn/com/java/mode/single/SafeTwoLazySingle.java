package cn.com.java.mode.single;

public class SafeTwoLazySingle {
    private static SafeTwoLazySingle single;

    private SafeTwoLazySingle(){}

    public static SafeTwoLazySingle getInstance(){
        if (single==null){
            synchronized (SafeTwoLazySingle.class){
                if (single==null)
                    single = new SafeTwoLazySingle();
            }
        }
        return single;
    }
}
