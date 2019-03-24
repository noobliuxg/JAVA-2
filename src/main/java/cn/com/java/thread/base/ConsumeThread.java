package cn.com.java.thread.base;

public class ConsumeThread implements Runnable{

    private Data data;

    public ConsumeThread(Data data) {
        this.data = data;
    }

    public void run() {
        while (true){
            synchronized (this.data){
                System.out.println(Thread.currentThread().getName() +"开始消费数据");
                if (this.data.getDatas()<=0){
                    try {
                        this.data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() +"消费："+this.data.removeData()+"成功,当前容器的数据有："+this.data.getDatas());
                this.data.notifyAll();
            }
        }
    }
}
