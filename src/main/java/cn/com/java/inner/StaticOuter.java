package cn.com.java.inner;

public class StaticOuter {

    private static String static_field = "outer_static_field";

    private String no_static_field = "outer_no_static_field";

    public static class StaticInner{
        private static String static_field = "inner_static_field";

        private String no_static_field = "inner_no_static_field";

        public void printInnerStatic(){
            System.out.println(static_field);
        }

        public void printOuterStatic(){
            System.out.println(StaticOuter.static_field);
        }

        private void printInnerNoStatic(){
            System.out.println(no_static_field);
        }

        private void printOuterNoStatic(){
            System.out.println(new StaticOuter().no_static_field);
        }
    }

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner();
        staticInner.printInnerStatic();
        staticInner.printOuterStatic();

        staticInner = new StaticOuter.StaticInner();

        staticInner.printInnerNoStatic();
        staticInner.printOuterNoStatic();
    }

}
