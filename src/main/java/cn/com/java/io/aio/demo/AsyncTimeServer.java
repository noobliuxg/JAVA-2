package cn.com.java.io.aio.demo;

public class AsyncTimeServer {

    public static void main(String[] args) {
        new Thread(new AsyncTimeServeHandler(8080),"AsncTimeSever-001").start();
    }
}
