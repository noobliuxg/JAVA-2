package cn.com.java.mode.factory.abstractor;

public abstract class AbstractFactory {

    public abstract Cpu buildCpu();

    public abstract Board buildBoard();

    public abstract Computer builder();
}
