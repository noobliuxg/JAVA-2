package cn.com.java.io.aio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements Runnable{


    private CountDownLatch latch;

    private AsynchronousSocketChannel clientChannel = null;

    private String host = null;

    private int port;

    public AsyncTimeClientHandler(String host,int port) {
        try {
            clientChannel = AsynchronousSocketChannel.open();
            this.host = host;
            this.port = port;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public AsynchronousSocketChannel getClientChannel() {
        return clientChannel;
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        clientChannel.connect(new InetSocketAddress(host,port),this,new AsyncClientCompletion());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
