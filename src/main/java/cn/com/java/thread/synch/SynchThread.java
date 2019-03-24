package cn.com.java.thread.synch;

public class SynchThread {

    public static void main(String[] args) {
        new Thread(() -> SynchThread.print(),"main-1").start();
        new Thread(() -> {SynchThread.print();},"main-2").start();
    }


    public static void print(){
        synchronized (SynchThread.class){
            System.out.println(Thread.currentThread().getName()+"运行");
        }
    }
}
