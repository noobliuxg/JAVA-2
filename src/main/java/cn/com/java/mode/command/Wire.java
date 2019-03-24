package cn.com.java.mode.command;

public class Wire {
    private Electric electric;

    public Wire(Electric electric) {
        this.electric = electric;
    }

    public void control(){
        this.electric.runAndStop();
    }
}
