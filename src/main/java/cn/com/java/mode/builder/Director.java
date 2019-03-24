package cn.com.java.mode.builder;

public class Director implements MailBuilderAware{

    private MailBuilder builder;

    public Director() {
    }

    public Director(MailBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void setMailBuilder(MailBuilder builder) {
        this.builder = builder;
    }

    public Mail getMail(){
        this.builder.buildAcceptor();
        this.builder.buildTitle();
        this.builder.buildContent();
        this.builder.buildFile();
        this.builder.buildSender();
        return this.builder.builder();
    }
}
