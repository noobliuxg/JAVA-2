package cn.com.java.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements Runnable{

    AsynchronousSocketChannel asChannel = null;

    private String host = null;

    private int port ;

    CountDownLatch latch;

    public AsyncTimeClientHandler(String host,int port) {
        try {
            this.host = host;
            this.port = port;
            asChannel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        doConnect();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doConnect() {

        asChannel.connect(new InetSocketAddress(host,port),this,new ConnectCompletionHander());
    }
}
