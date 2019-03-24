一.线程常用的方法：join,yield,start,wait,nodify/nodify,interrupt(),interrupted()
1.1 join：比如：在A线程里面调用B线程的join方法，这时A线程会暂停使用，等待b线程执行完毕后，A线程才会开始执行
1.2 yield：当前执行的线程会让出CPU的资源，进入等待状态，让别的等待执行的线程执行
1.3 start：启动一个线程，等待获取CPU的执行
1.4 wait nodify/nodifyAll:wait让持有当前锁对象的线程休眠，并释放当前锁对象，nodify/nodifyAll：唤醒所有锁对象的线程
1.5 interrupt 终止线程的运行，isInterrupt：当前线程是否已被终止，interrupted：终止当前线程的运行
二.线程创建的方式：
    implements Runnable,extends Thread,implements Callable.
三.线程同步：synchronized,Lock
Lock的常用API：lock(),unLock(),tryLock(),lockInterruptibly()/interrupt()
死锁：
乐观锁：
悲观锁：

三.常用的容器
BlockingQueue:
    ArrayBlockingQueue,LinkedBlockingQueue,SynchronousQueue,PriorityBlockingQueue
    ArrayBlockingQueue：基于数组实现的又缓冲的阻塞队列，且必须指明队列的大小，生成和消费不能并发执行
    		  					原理：内部维护一个定长数组，且没有实现读写分离，故不能做到生成和消费并发执行，
    LinkedBlockingQueue：基于链表实现的有缓冲的阻塞队列，且不必指明队列的大小
    		  					原理：内部维护一个链表接口，且实现了读写分离锁，故能做到生成和消费并发执行
   SynchronousQueue：一个没有缓冲的队列，必须是实时地生成和消费
   PriorityBlockingQueue<Object必须实现Compont接口>：基于优先集的阻塞队列，
    		  					原理：内部采用的是一种公平锁，在取出元素时进行排序，而不是在运行时
   DelayQueue<Object必须实现Delayed接口>：一个带有延迟时间的Queque，即延迟时间到了，才能从队列中拿出元素
四.线程池
常用API：
    submit()：添加运行任务，并执行运行任务。
    execute()：运行任务。
    shutdown()：关闭线程池，拒绝任务在添加到线程池中，但不会终止当前正在运行的任务。
    shutdownNow()：关闭线程池，拒绝任务再添加到线程池中哦，但会终止当前正在运行的任务。
常用的类：ThreadPoolExecutor->AbstractExecutorService->>ExecutorService->Executor,Executor<-ExecutorService<-ScheduledExecutorService<<-ScheduledThreadPoolExecutor->ThreadPoolExecutor
ThreadPoolExecutor(int,int,long,TimeUnit,BlockingQueue,ThreadFactory,RejectedExecutionHandler);
        Executors.newCachedThreadPool();//无休止的线程
        Executors.newFixedThreadPool(5);//新建一个固定的线程的线程池
        Executors.newSingleThreadExecutor();//新建一个单线程的线程池
        Executors.newScheduledThreadPool(4);//新建一个固定数据量的线程池的定时任务