package cn.com.java.mode.single;

public class InitHungrySingle {

    private static InitHungrySingle single = new InitHungrySingle();

    private InitHungrySingle(){}

    public static InitHungrySingle getInstance(){
        return single;
    }
}
