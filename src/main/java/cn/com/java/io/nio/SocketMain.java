package cn.com.java.io.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketMain {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);//设置为非阻塞的
        socketChannel.connect(new InetSocketAddress("http://127.0.0.1",8080));
        if (socketChannel.finishConnect()){
            //从管道中读取数据
            ByteBuffer rbuff = ByteBuffer.allocate(1024);
            rbuff.clear();
            int read = socketChannel.read(rbuff);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while(read>0){
                rbuff.flip();
                byte[] buffer = new byte[read];
                int i=0;
                while (rbuff.hasRemaining()){
                    buffer[i] = rbuff.get();
                    i++;
                }
                baos.write(buffer);
                rbuff.clear();
                read = socketChannel.read(rbuff);
            }


            //往管道中写入数据
            ByteBuffer wbuff = ByteBuffer.allocate(1024);
            wbuff.put("liuxginguaiaiisiisis".getBytes());
            wbuff.flip();
            while (wbuff.hasRemaining()){
                socketChannel.write(wbuff);
            }
        }
        socketChannel.close();
    }
}
