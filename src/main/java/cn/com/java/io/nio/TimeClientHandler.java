package cn.com.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class TimeClientHandler implements Runnable{


    private SocketChannel socketChannel;
    private Selector selector;
    private String host = "http://127.0.0.1";
    private int port = 0;

    private volatile boolean flag = false;

    public TimeClientHandler(String host,int port) {
        try {
            socketChannel = SocketChannel.open();
            if(host!=null && !host.equals("")){
                this.host = host;
            }
            if(port>0){
                this.port = port;
            }
            socketChannel.configureBlocking(false);
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!flag){
            try {
                selector.select(100);
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    handleInput(selectionKey);
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


    private void handleInput(SelectionKey selectionKey) throws IOException {
        if(selectionKey.isValid()){
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            if (channel.finishConnect()){
                channel.register(selector,SelectionKey.OP_READ);
                doWrite(channel);
            }else{
                System.exit(1);
            }
            if(selectionKey.isReadable()){
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int read = channel.read(buffer);
                StringBuffer stringBuffer = new StringBuffer();
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

    private void doWrite(SocketChannel channel) {
    }

    private void stop(){
        this.flag = true;
    }

    private void doConnect() throws IOException {
        if (socketChannel.connect(new InetSocketAddress(host,port))){
            socketChannel.register(selector, SelectionKey.OP_READ);
        }else {
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }

    }
}
