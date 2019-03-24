package cn.com.java.thread.base;

public class JoinThread {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "读取excel");
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "读取excel完毕");
                    break;
                }
            }
        }, "main-1");


        t1.start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("等待main-1读取excel操作完毕后");
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("读取excel操作完毕后，进行excle汇总");
            }
        },"main-2").start();
    }
}
