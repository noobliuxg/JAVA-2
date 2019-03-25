package cn.com.java.thread.base;

import java.util.concurrent.*;

public class CalledThread {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(() -> "ab");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
