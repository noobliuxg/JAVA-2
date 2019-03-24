package cn.com.java.thread.synch;


import cn.com.java.thread.threadpool.ThreadPool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockThread {
    private final static Lock LOCK = new ReentrantLock();
    private final static Lock INTERRUPT_LOCK = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(()->{LockThread.tryPrint();},"main-1").start();
        new Thread(()->{LockThread.tryPrint();},"main-2").start();
        new Thread(()->{LockThread.print();},"main-3").start();
        new Thread(()->{LockThread.print();},"main-4").start();
        Thread t1 = new Thread(() -> {
            try {
                LockThread.interruptPrint();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName()+"中断等待");
            }
        }, "main-5");
        Thread t2 = new Thread(() -> {
            try {
                LockThread.interruptPrint();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName()+"中断等待");
            }
        }, "main-6");
        t1.start();
        t2.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }

    private static void tryPrint(){
        if (LOCK.tryLock()){
            try {
                System.out.println(Thread.currentThread().getName()+"获取锁成功");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                LOCK.unlock();
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"获取锁失败");
        }
    }

    private static void print(){
        LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"运行");
        } finally {
            LOCK.unlock();
        }
    }


    private static void interruptPrint() throws InterruptedException {
        INTERRUPT_LOCK.lockInterruptibly();
        try {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行");
        } finally {
            System.out.println(Thread.currentThread().getName()+"运行结束，释放锁");
            INTERRUPT_LOCK.unlock();
        }
    }
}
