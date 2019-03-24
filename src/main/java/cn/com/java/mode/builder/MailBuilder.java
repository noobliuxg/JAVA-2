package cn.com.java.mode.builder;

public abstract class MailBuilder {
    public abstract void buildTitle();
    public abstract void buildContent();
    public abstract void buildFile();
    public abstract void buildSender();
    public abstract void buildAcceptor();

    public abstract Mail builder();
}
