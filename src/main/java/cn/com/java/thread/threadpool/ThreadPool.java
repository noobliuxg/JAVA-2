package cn.com.java.thread.threadpool;

import java.util.concurrent.*;

public class ThreadPool {

    private static final ExecutorService service = new ThreadPoolExecutor(5, 50, 2, TimeUnit.SECONDS, new LinkedBlockingQueue(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for(int i=0;i<55;i++){
            final int temp = i;
            service.submit(new Runnable() {
                public void run() {
                    System.out.println(temp);
                }
            });
//            if (temp==40){
//                service.shutdownNow();
//            }
        }
        while (service.isShutdown()){
        }
        service.shutdown();
//        service.shutdown();
        System.out.println("线程池结束运行");
//        service.shutdown();
//        service.isShutdown();

    }
}
