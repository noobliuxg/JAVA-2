package cn.com.java.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureThread {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            public String call() throws Exception {
                return "futureTask";
            }
        });
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        boolean done = futureTask.isDone();
        if (done){
        }
    }
}
