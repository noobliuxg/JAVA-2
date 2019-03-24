package cn.com.java.thread.base;

public class YieldThread {
    public static void main(String[] args) {
        Thread yieldThread = new Thread(new Runnable() {
            public void run() {
                int i =1;
                while (true){
                    i++;
                    System.out.println(i);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   if (i>20){
                        break;
                    }
                }
            }
        },"thread-yield");
        yieldThread.start();

        Thread mainThread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"结束运行");
            }
        },"thread-main");
        mainThread.start();
    }
}
