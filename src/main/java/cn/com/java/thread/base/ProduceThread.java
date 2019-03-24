package cn.com.java.thread.base;


public class ProduceThread implements Runnable{

    private Data data;

    public ProduceThread(Data data) {
        this.data = data;
    }

    public void run() {
        while (true){
            synchronized (this.data){
                System.out.println(Thread.currentThread().getName() +"开始生产数据");
                while (this.data.getDatas()>10){
                    try {
                        this.data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.data.addData(Thread.currentThread().getName() +"生产者生产Data")+"，当前数据有："+this.data.getDatas());
                this.data.notifyAll();
            }
        }
    }
}
