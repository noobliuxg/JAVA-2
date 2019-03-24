主要API：
Selector：管理channel的注册器
        相关API：
            Selector.open()：开启通道
            select()：此方法会阻塞直到Selector中由通道由就绪事件发生
                    就绪事件：connect accept read write,对应的常量：SelectionKey.OP_CONNECT,SelectionKey.OP_ACCEPT,SelectionKey.OP_READ,SelectionKey.OP_WRITE
            select(long timeout):和select()一样，除了最长会阻塞timeout毫秒(参数)
            selectNow():不会阻塞，不管什么通道就绪都会返回
            wikeup()：唤醒阻塞在select()方法上的线程
            close()：关闭Selector
            selectedKeys()：返回所有Selector中通道就绪的SelectedKey
            int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;拼接多个就绪事件
SelectionKey：注册到Selector中的唯一凭证对象
        相关API：
            selector():获取Selector
            channel()：获取通道
            isAcceptable():接受就绪==>int interestSet = selectionKey.interestOps(); intersSet&SelectionKey.OP_ACCEPT
            isConnectable():连接就绪
            isReadable()：读就绪
            isWritable():写就绪
Channel
    FileChannel
    ServerSocketChannel
    SocketChannel
    DatagramChannel
    相关API：
        configureBlocking(false)：将通道设置为阻塞状态
        register(selector,Selectionkey),将channel注册到Selector中

Buffer
    ByteBuffer
    LongBuffer
    DoubleBuffer
    Buffer的几个相关知识点：capacity limit position
        capacity:表示容器的大小
        limit：表示当前可写入或可读入的数据的长度
        position：表示当前下一个可读或可写元素的位置

    相关API：
        flip()：将buffer从写模式下变为读模式，其实原理就是：将limit=position,position=0
        clear()：将buffer从写模式变为读模式，其实就是：将limit=capacity,position=0
        rewind()：将buffer中position=0,limit不变
        mark()/reset()：将buffer中的position=mark

主要API解释：
Selector：类似于煤矿管理员，Channel：类似于运输煤炭的卡车，Buffer：煤炭


