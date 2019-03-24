package cn.com.java.mode.command.base;

public class Invoker {

    private Command command;

    public void invoke(){
        command.execute();
    }

}
