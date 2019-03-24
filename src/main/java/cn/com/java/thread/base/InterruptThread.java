package cn.com.java.thread.base;

public class InterruptThread implements Runnable{
    private volatile int i=0;
    public void run() {
        while (true){
            i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i>20){
                break;
            }
        }
    }

    public int getI(){
        return i;
    }


    public static void main(String[] args) {
        InterruptThread thread = new InterruptThread();
        Thread t1 = new Thread(thread,"t1");
        t1.start();
        while (true){
            if (thread.getI()==10){
                t1.interrupt();
                break;
            }
        }
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1是否被中断执行"+t1.isInterrupted());
        System.out.println("t1是否被存活"+t1.isAlive());
        Thread.currentThread().interrupt();
        System.out.println("第一次调用Thread.currentThread().interrupt()："
                +Thread.currentThread().isInterrupted());
        System.out.println("第一次调用thread.interrupted()："
                +Thread.currentThread().interrupted());
        System.out.println("第二次调用thread.interrupted()："
                +Thread.currentThread().interrupted());

    }
}
