package cn.com.java.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferMain {

    public static void main(String[] args) throws IOException {
        String msg = "liuxg";
        RandomAccessFile file = new RandomAccessFile("d:/data.txt","rw");
//        file.write(msg.getBytes());
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1);
        int read = channel.read(buffer);//将数据读取到buffer缓冲区中,即：写入到Buffer中
        StringBuffer stringBuffer = new StringBuffer();
        while (read!=-1){
            buffer.flip();//将buffer从写模式改为读模式，即：limit=position,position=0
            char[] cbuff = new char[read];
            int i=0;
            while (buffer.hasRemaining()){
                cbuff[i] = (char)buffer.get(); //从buffer容器中读取数据，即：将buffer中的数据读出到内存中
                i++;
            }
            stringBuffer.append(new String(cbuff));

            buffer.clear();

            read = channel.read(buffer);
        }
        System.out.println(stringBuffer.toString());
        file.close();

        file = new RandomAccessFile("d:/data3.txt","rw");
        channel = file.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("liuxinguai".getBytes());//将内存中的数据写入到buffer中，即：写

        byteBuffer.flip();

        channel.write(byteBuffer);//将buffer中数据读入到Channel，即：读

//        byteBuffer.reset();

//        channel.read(byteBuffer);

        file.close();

    }
}
