package cn.com.java.io.base;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PipedMain {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);

        Runnable receive = new Receive(latch);
        Runnable send = new Send(latch);

        try {
            ((Send) send).getPos().connect(((Receive) receive).getPis());
        } catch (IOException e) {
            e.printStackTrace();
        }
        service.submit(send);
        service.submit(receive);

        service.shutdown();
        System.out.println(System.currentTimeMillis());
        latch.await();
        System.out.println("管道交流结束"+System.currentTimeMillis());
    }

    static class Receive implements Runnable{

        private PipedInputStream pis = null;

        private CountDownLatch latch = null;

        public Receive(CountDownLatch latch) {
            pis = new PipedInputStream();
            this.latch = latch;
        }

        public void connect(PipedOutputStream pos){
            try {
                pos.connect(pis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public PipedInputStream getPis() {
            return pis;
        }

        @Override
        public void run() {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            for (;;) {
                try {
                    byte[] cbuff = new byte[1024];
                    int len = pis.read(cbuff);
                    if (len <= 0) break;
                    bos.write(cbuff, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"接收到的消息："+new String(bos.toByteArray()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.latch.countDown();
            System.out.println(this.latch.getCount());
        }
    }

    static class Send implements Runnable{

        private CountDownLatch latch = null;
        private PipedOutputStream pos = null;

        public Send(CountDownLatch latch) {
            pos = new PipedOutputStream();
            this.latch = latch;
        }


        @Override
        public void run() {
            try {
                pos.write(new String(Thread.currentThread().getName()+"发送的数据").getBytes());
                pos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.latch.countDown();
            System.out.println(this.latch.getCount());
        }

        public PipedOutputStream getPos() {
            return pos;
        }
    }
}
