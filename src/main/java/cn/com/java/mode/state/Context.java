package cn.com.java.mode.state;

public class Context {

    protected  State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request(){
        state.handler();
    }
}
