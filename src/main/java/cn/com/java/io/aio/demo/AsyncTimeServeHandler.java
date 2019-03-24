package cn.com.java.io.aio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServeHandler implements Runnable{


    private AsynchronousServerSocketChannel asssChannel;

    private CountDownLatch latch;

    public AsyncTimeServeHandler(int port) {
        try {
            asssChannel = AsynchronousServerSocketChannel.open();
            asssChannel.bind(new InetSocketAddress(port),1024);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }


    public AsynchronousServerSocketChannel getAsssChannel() {
        return asssChannel;
    }


    @Override
    public void run() {
        latch = new CountDownLatch(1);
        asssChannel.accept(this,new AcceptAsyncServerCompletionHandler());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
