package cn.com.java.mode.observer;

public class ConcreteSubject extends Subject{
    @Override
    public void nodify() {
        for (Observer observer : observers){
            observer.update();
        }
    }
}
