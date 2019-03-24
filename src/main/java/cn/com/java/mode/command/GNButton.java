package cn.com.java.mode.command;

public class GNButton extends Button{

    public GNButton(Wire wire) {
        this.wire = wire;
    }

    @Override
    public void onClick() {
        this.wire.control();
    }
}
