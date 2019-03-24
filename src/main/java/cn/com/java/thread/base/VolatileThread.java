package cn.com.java.thread.base;

public class VolatileThread implements Runnable{

    private volatile boolean flag = true;

    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程执行开始执行run方法");
        while (flag){
            System.out.println(Thread.currentThread().getName()+"线程执行执行run方法");
        }
        System.out.println(Thread.currentThread().getName()+"线程执行结束执行run方法");
    }

    public void stop(){
        flag = false;
    }

    public static void main(String[] args){
        final VolatileThread volatileThread = new VolatileThread();
        new Thread(volatileThread,"main-2").start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"终止main-2线程的运行");
                volatileThread.stop();
            }
        },"main-1").start();
    }
}
