package cn.com.java.io.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int port = 8080;

    private static volatile boolean flag = true;

    private static final ExecutorService service = Executors.newFixedThreadPool(16);

    public Server(int port){
        this.port = port;
    }

    public void start(){
        try {
            ServerSocket socket = new ServerSocket(this.port);
            System.out.println(socket);
            while (flag){
                Socket accept = socket.accept();
                service.submit(new ServerHandler(accept));
            }
            service.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stop(){
        flag = false;
    }

    class ServerHandler implements Runnable{

        private Socket socket = null;

        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader bis = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                StringBuffer sbuffer = new StringBuffer();
                String readLine = bis.readLine();
                sbuffer.append(readLine);
                System.out.println(sbuffer.toString());
                if (sbuffer.toString().equals("exit")){
                    Server.stop();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (this.socket != null){
                    try {
                        this.socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
