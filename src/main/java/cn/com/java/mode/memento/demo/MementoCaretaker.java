package cn.com.java.mode.memento.demo;

public class MementoCaretaker {

    private ChessmanMemento chessmanMemento;

    public MementoCaretaker() {
    }

    public MementoCaretaker(ChessmanMemento chessmanMemento) {
        this.chessmanMemento = chessmanMemento;
    }

    public ChessmanMemento getChessmanMemento() {
        return chessmanMemento;
    }

    public void setChessmanMemento(ChessmanMemento chessmanMemento) {
        this.chessmanMemento = chessmanMemento;
    }
}
