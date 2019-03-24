package cn.com.java.inner;

public class MethodOuter {

    public void show(){
        int x=0;
        int y = 1;
        class MethodInner{
            public int add(){
                return x+y;
            }
        }
        System.out.println(new MethodInner().add());
    }

    public static void main(String[] args) {
        new MethodOuter().show();
    }
}
