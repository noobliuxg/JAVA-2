package cn.com.java.thread.synch;

public class DeadLock {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(()->{a();},"main-1").start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{b();},"main-2").start();
    }

    private static void a(){
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"运行a()");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"等待运行b()");
            b();
        }
    }

    private static void b(){
        synchronized (lockB){
            System.out.println(Thread.currentThread().getName()+"运行b()");
            System.out.println(Thread.currentThread().getName()+"等待运行a()");
            a();
        }
    }
}
