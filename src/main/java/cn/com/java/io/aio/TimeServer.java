package cn.com.java.io.aio;

public class TimeServer {
    public static void main(String[] args) {
        new Thread(new AsyncTimeServerHandler(8080), "AIO-AsyncTimeServerHandler-001").start();

    }
}
