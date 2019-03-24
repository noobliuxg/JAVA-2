package cn.com.java.io.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class SelectorMain {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        //非阻塞的
        serverChannel.configureBlocking(false);

        //开启Selector
        Selector selector = Selector.open();

        //往Selector中注册Channel，监听接受就绪事件和读就绪事件以及写就绪事件
        SelectionKey key = serverChannel.register(selector, SelectionKey.OP_ACCEPT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);

        key.attach(new String("AABBCC"));//给selectionKey中额外地绑定对象
        while (true){
            if (selector.select()<=0)continue;//select()方法会导致主线程一直阻塞在此，知道有通道触发了就绪事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isAcceptable()){//接收就绪事件
                    next.attachment();//获取绑定在通道中的对象
                }else if(next.isConnectable()){//连接就绪事件

                }else if(next.isReadable()){//读就绪事件

                }else if(next.isWritable()){//写就绪事件

                }
                iterator.remove();//删除已经处理过的就绪事件
            }
        }
//        selector.close(); 关闭selector
    }
}
