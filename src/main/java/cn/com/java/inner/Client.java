package cn.com.java.inner;

public class Client {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.PulicInner inner = outer.new PulicInner();
        inner.show();

        Outer.ProtectedInner aProtected = outer.getProtected();
        aProtected.show();


        Outer.DefaultInner aDefault = outer.getDefault();
        aDefault.show();
    }
}
