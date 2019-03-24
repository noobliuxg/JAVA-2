package cn.com.java.io.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

public class ConnectCompletionHander implements CompletionHandler<Void, AsyncTimeClientHandler> {


    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        attachment.asChannel.write(writeBuffer, writeBuffer,
                new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer buffer) {
                        if (buffer.hasRemaining()) {
                            attachment.asChannel.write(buffer, buffer, this);
                        } else {
                            ByteBuffer readBuffer = ByteBuffer.allocate(4);
                            attachment.asChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                                @Override
                                public void completed(Integer result, ByteBuffer buffer) {
                                    buffer.flip();
                                    byte[] bytes = new byte[buffer.remaining()];
                                    buffer.get(bytes);
                                    String body;
                                    try {
                                        body = new String(bytes, "UTF-8");
                                        System.out.println("Now is : " + body);
                                        attachment.latch.countDown();
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void failed(Throwable exc, ByteBuffer attachment) {
                                }
                            });
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                    }
                });

    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        try {
            attachment.asChannel.close();
            attachment.latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
