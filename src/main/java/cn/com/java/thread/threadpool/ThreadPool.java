package cn.com.java.thread.threadpool;

import java.util.concurrent.*;

public class ThreadPool {

    /**
     * RejectedExecutionHandler
     * AbortPolicy:抛出异常
     * DiscardPolicy：不作为
     * DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     * CallerRunsPolicy：由调用线程处理该任务
     */
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
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(3);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(3);
    }
}
