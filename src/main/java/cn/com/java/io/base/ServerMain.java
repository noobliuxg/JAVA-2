package cn.com.java.io.base;

public class ServerMain {

    public static void main(String[] args) {
        Server server = new Server(8081);
        new Thread(new Runnable() {
            @Override
            public void run() {
                server.start();
            }
        }).start();


        new Client(8081,"127.0.0.1").send("刘新乖面试1").run();
        new Client(8081,"127.0.0.1").send("刘新乖面试2").run();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Client(8081,"127.0.0.1").send("exit").run();
        new Client(8081,"127.0.0.1").send("exit2").run();
    }
}
