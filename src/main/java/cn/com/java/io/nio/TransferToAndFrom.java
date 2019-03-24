package cn.com.java.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferToAndFrom {

    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("d:/data4.txt","rw");
        FileChannel fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("d:/data6.txt","rw");
        FileChannel toChannel = toFile.getChannel();
//        toChannel.transferFrom(fromChannel,0,fromChannel.size());

        fromChannel.transferTo(0,fromChannel.size(),toChannel);

    }
}
