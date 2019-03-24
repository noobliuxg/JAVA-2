package cn.com.java.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable{

    private int port;

    CountDownLatch latch;

    AsynchronousServerSocketChannel assChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;

        try {
            assChannel = AsynchronousServerSocketChannel.open();
            assChannel.bind(new InetSocketAddress(this.port));
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept() {
        assChannel.accept(this,new AcceptCompletionHandler());
    }
}
