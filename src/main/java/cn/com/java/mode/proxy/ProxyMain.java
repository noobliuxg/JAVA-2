package cn.com.java.mode.proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {

    public static void main(String[] args) {
        Hello realHello = new HelloImpl();

        Hello proxyHello = (Hello) Proxy.newProxyInstance(realHello.getClass().getClassLoader(), new Class[]{Hello.class}, (proxy, method, args1) -> {
//                System.out.println(proxy);
            System.out.println(" proxy before :");
            Object invoke = method.invoke(realHello, args1);
            System.out.println("proxy after ");
            return invoke;
        });

//        System.out.println(proxyHello.getClass().getName());
        proxyHello.println();

    }
}
