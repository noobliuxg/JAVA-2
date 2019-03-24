package cn.com.java.mode.memento.demo;

import java.util.ArrayList;
import java.util.List;

public class MementoCaretakers {

    private List<ChessmanMemento> mementos = new ArrayList<>(10);

    public ChessmanMemento getMemento(int i){
        return mementos.get(i);
    }

    public void setMemento(ChessmanMemento memento){
        mementos.add(memento);
    }
}
