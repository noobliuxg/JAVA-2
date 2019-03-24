package cn.com.java.io.aio.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

public class AsyncClientCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsyncTimeClientHandler clientHandler = null;

    public AsyncClientCompletionHandler(AsyncTimeClientHandler attachment) {
        this.clientHandler = attachment;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        if(attachment.hasRemaining()){//继续读取数据
            this.clientHandler.getClientChannel().write(attachment,attachment,this);
        }else{
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();

            clientHandler.getClientChannel().read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    attachment.flip();

                    byte[] buff = new byte[attachment.remaining()];

                    System.out.println(new String(buff));
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        clientHandler.getClientChannel().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    clientHandler.getLatch().countDown();
                }
            });
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            clientHandler.getClientChannel().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientHandler.getLatch().countDown();
    }
}
