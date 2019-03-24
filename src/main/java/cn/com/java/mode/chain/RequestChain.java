package cn.com.java.mode.chain;

public abstract class RequestChain {

    protected RequestChain requestChain;

    public abstract void handle(Request request);
}
