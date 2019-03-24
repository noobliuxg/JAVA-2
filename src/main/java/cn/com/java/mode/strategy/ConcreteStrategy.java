package cn.com.java.mode.strategy;

public class ConcreteStrategy extends AbstractStategy{
    @Override
    public void algorithm() {
        System.out.println("具体的算法");
    }
}
