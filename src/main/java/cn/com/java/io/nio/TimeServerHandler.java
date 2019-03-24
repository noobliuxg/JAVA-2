package cn.com.java.io.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class TimeServerHandler implements Runnable{

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    private volatile boolean flag = false;

    public TimeServerHandler(int port) {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port),1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("<The Time Server start in port :>"+port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void stop(){
        this.flag = true;
    }

    @Override
    public void run() {
        while (!flag){
            try {
                selector.select(100);
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    handleOutput(selectionKey);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        if (selector!=null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleOutput(SelectionKey selectionKey) throws IOException {
        if(selectionKey.isValid()){
            if(selectionKey.isAcceptable()){
                ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                SocketChannel accept = channel.accept();
                accept.configureBlocking(false);
                accept.register(selector,SelectionKey.OP_READ);
            }
            if(selectionKey.isReadable()){
                SocketChannel channel = (SocketChannel)selectionKey.channel();
                ByteBuffer buffer = ByteBuffer.allocate(512);
                StringBuffer stringBuffer = new StringBuffer();
                int read = channel.read(buffer);
                while (read>0){
                    buffer.flip();
                    byte[] cbuff = new byte[buffer.remaining()];
                    buffer.get(cbuff);
                    buffer.clear();
                    read = channel.read(buffer);
                    stringBuffer.append(new String(cbuff));
                }
                selectionKey.cancel();
                channel.close();
                stop();
            }
        }

    }
}
