package cn.com.java.mode.memento;

/**
 * 原生器
 */
public class Originator {

    private String state;

    public Originator() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(this);
    }

    public void restoreMemento(Memento memento){
        this.setState(memento.getState());
    }
}
