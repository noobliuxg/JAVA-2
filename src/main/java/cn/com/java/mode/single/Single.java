package cn.com.java.mode.single;

public class Single {


    public static Single getInstance(){
        return InnerSingle.single;
    }

    private static class InnerSingle {
        private static Single single = new Single();
    }

}
