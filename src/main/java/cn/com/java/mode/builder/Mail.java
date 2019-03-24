package cn.com.java.mode.builder;

public class Mail {
    private String title;
    private String content;
    private String file;
    private String sender;
    private String acceptor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", file='" + file + '\'' +
                ", sender='" + sender + '\'' +
                ", acceptor='" + acceptor + '\'' +
                '}';
    }
}
