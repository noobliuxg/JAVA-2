package cn.com.java.mode.memento.demo;

public class Chessman {
    private String label;
    private int x;
    private int y;

    public Chessman(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ChessmanMemento save(){
        return new ChessmanMemento(this);
    }

    public void restore(ChessmanMemento chessmanMemento){
        this.label = chessmanMemento.getLabel();
        this.x = chessmanMemento.getX();
        this.y = chessmanMemento.getY();
    }
}
