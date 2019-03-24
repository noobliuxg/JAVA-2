package cn.com.java.mode.builder;

public class WageBuiler extends MailBuilder{

    private Mail mail = null;

    public WageBuiler() {
        mail = new Mail();
    }

    @Override
    public void buildTitle() {
        this.mail.setTitle("工资明细");
    }

    @Override
    public void buildContent() {
        this.mail.setContent("详细的工资条明细");
    }

    @Override
    public void buildFile() {
        this.mail.setFile("工资条附件");
    }

    @Override
    public void buildSender() {
        this.mail.setSender("财务人员");
    }

    @Override
    public void buildAcceptor() {
        this.mail.setAcceptor("员工");
    }

    @Override
    public Mail builder() {
        return mail;
    }
}
