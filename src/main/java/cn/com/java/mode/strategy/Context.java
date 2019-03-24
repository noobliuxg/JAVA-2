package cn.com.java.mode.strategy;

public class Context {
    private AbstractStategy stategy;

    public Context(AbstractStategy stategy) {
        this.stategy = stategy;
    }

    public void algorithm(){
        this.stategy.algorithm();
    }
}
