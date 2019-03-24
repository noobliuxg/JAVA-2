package cn.com.java.io.aio.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AsyncSeverCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socketChannel = null;

    public AsyncSeverCompletionHandler(AsynchronousSocketChannel result) {
        this.socketChannel = result;
    }


    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();

        //读取来自客户的请求数据
        byte[] buffer = new byte[1024];
        attachment.get(buffer);
        System.out.println("接受来之客户的请求数据:"+new String(buffer));

        attachment.clear();

        //将数据写回客户端
        byte[] content = ("The Sever send to client :"+System.currentTimeMillis()).getBytes();
        ByteBuffer wbuff = ByteBuffer.allocate(content.length);
        wbuff.clear();
        wbuff.put(content);
        wbuff.flip();
        socketChannel.write(wbuff, wbuff, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                while (attachment.hasRemaining()){
                    socketChannel.write(attachment,attachment,this);
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
