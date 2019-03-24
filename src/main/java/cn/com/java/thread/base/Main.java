package cn.com.java.thread.base;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(new ProduceThread(data),"produce-1").start();
        new Thread(new ConsumeThread(data),"consume-1").start();
    }
}
