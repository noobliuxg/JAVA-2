package cn.com.java.io.nio;

public class TimeServer {

    public static void main(String[] args) {
        new Thread(new TimeServerHandler(8080),"TIMESEVER-001").start();
    }
}
