package cn.com.java.mode.command.base;

public class SpecificCommand implements Command{

    private Receiver receiver;

    public SpecificCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
    }
}
