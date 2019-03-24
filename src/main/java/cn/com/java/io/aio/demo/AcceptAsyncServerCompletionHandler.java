package cn.com.java.io.aio.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptAsyncServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServeHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServeHandler attachment) {
        attachment.getAsssChannel().accept(attachment,this);//循环监听来着客户端的接口
        ByteBuffer buffer = ByteBuffer.allocate(1024);//初始化一个buffer缓冲区
        //处理这次来自于客户端的请求
        result.read(buffer,buffer,new AsyncSeverCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServeHandler attachment) {
        try {
            attachment.getAsssChannel().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        attachment.getLatch().countDown();

    }
}
