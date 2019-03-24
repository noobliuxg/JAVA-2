package cn.com.java.mode.single;

public class StaticHungrySingle {
    private static StaticHungrySingle single;
    static {
        single = new StaticHungrySingle();
    }

    private StaticHungrySingle(){}
    public static StaticHungrySingle getInstance(){
        return single;
    }
}
