package cn.com.java.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class ScatteringMain {

    public static void main(String[] args) throws IOException {
        RandomAccessFile rsf = new RandomAccessFile("d:/data3.txt","rw");

        //scatteringRead
        FileChannel channel = rsf.getChannel();

        ByteBuffer headBuffer = ByteBuffer.allocate(2);
        ByteBuffer bodyBuffer = ByteBuffer.allocate(24);

        channel.read(new ByteBuffer[]{headBuffer,bodyBuffer});

        headBuffer.flip();
        bodyBuffer.flip();

        println("head: ",headBuffer);
        println("body: ",bodyBuffer);

        rsf.close();
        //scattering Write

        rsf = new RandomAccessFile("d:/data4.txt","rw");
        channel = rsf.getChannel();
        headBuffer = ByteBuffer.allocate(20);
        bodyBuffer = ByteBuffer.allocate(24);

        headBuffer.put("liuxinguaimianshi".getBytes());
        bodyBuffer.put("guanshilaimianshi".getBytes());

        headBuffer.flip();
        bodyBuffer.flip();

        channel.write(new ByteBuffer[]{headBuffer,bodyBuffer});

        rsf.close();
    }


    public static void println(String bufferName,ByteBuffer byteBuffer){
        List list = new ArrayList<>();
        while (byteBuffer.hasRemaining()){
            list.add((char)byteBuffer.get());
        }
        System.out.print(bufferName);
        list.forEach(obj -> {
            System.out.print(obj);
        });
        System.out.println();
    }
}
