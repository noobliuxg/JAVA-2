package cn.com.java.io.aio.demo;

public class AsyncTimeClient {

    public static void main(String[] args) {
        new Thread(new AsyncTimeClientHandler("http://127.0.0.1",8080),"The Client-001").start();
    }
}
