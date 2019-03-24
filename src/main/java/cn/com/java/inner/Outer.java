package cn.com.java.inner;

public class Outer {

    private String key;

    public Outer() {
    }

    public Outer(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void println(){
        System.out.println(new OtherFieldInner().getName());
    }

    public class SameFieldInner{
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void showInner(){
            System.out.println("key : "+key);
            System.out.println("get key method :"+getKey());
        }

        public void showOuter(){
            System.out.println("key : "+Outer.this.key);
            System.out.println("get key method : "+Outer.this.getKey());
        }
    }

    public class OtherFieldInner{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class PulicInner{
        public void show(){
            System.out.println("public show ");
        }
    }

    private class PrivateInner{
        public void show(){
            System.out.println("private show");
        }
    }

    public PrivateInner getPrivate(){
        return this.new PrivateInner();
    }

    protected class ProtectedInner{
        public void show(){
            System.out.println("protected show");
        }
    }

    public ProtectedInner getProtected(){
        return this.new ProtectedInner();
    }

    class DefaultInner{
        public void show(){
            System.out.println("default show");
        }
    }

    public DefaultInner getDefault(){
        return this.new DefaultInner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        PulicInner inner = outer.new PulicInner();
        inner.show();

        PrivateInner privateInner = outer.new PrivateInner();
        privateInner.show();

        outer.setKey("Outer key");

        SameFieldInner sameFieldInner = outer.new SameFieldInner();
        sameFieldInner.setKey("inner key");
        sameFieldInner.showInner();
        sameFieldInner.showOuter();
    }

}
