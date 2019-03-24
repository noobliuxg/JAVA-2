package cn.com.java.io.aio.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

public class AsyncClientCompletion implements CompletionHandler<Void, AsyncTimeClientHandler> {
    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        //往channel中写入数据
        ByteBuffer wbuffer = ByteBuffer.allocate(1024);
        wbuffer.clear();
        wbuffer.put(("The Client send to Server of msg is :"+System.currentTimeMillis()).getBytes());
        wbuffer.flip();
        attachment.getClientChannel().write(wbuffer,wbuffer,new AsyncClientCompletionHandler(attachment));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        try {
            attachment.getClientChannel().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        attachment.getLatch().countDown();
    }

}
