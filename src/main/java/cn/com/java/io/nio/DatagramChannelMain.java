package cn.com.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelMain {

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(8080));
        datagramChannel.configureBlocking(false);

        //从channel中读取数据
        ByteBuffer wBuffer = ByteBuffer.allocate(24);
        wBuffer.clear();
        datagramChannel.receive(wBuffer);

        //往channel中写入数据
        ByteBuffer rBuffer = ByteBuffer.allocate(24);
        rBuffer.clear();
        rBuffer.put("留下难怪sfsdf".getBytes());
        datagramChannel.send(rBuffer,new InetSocketAddress("127.0.0.1",8089));
    }
}
