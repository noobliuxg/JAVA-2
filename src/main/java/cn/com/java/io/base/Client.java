package cn.com.java.io.base;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client implements Runnable{

    private int port = 8080;

    private String url = "127.0.0.1";

    private String msg = "";

    public Client(int port,String host) {
        this.port = port;
        this.url = host;
    }

    public Client send(String msg){
        this.msg = msg;
        return this;
    }

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket(url,port);
            if (socket.isConnected()){
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.write(this.msg);
                writer.flush();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
