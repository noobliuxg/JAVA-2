package cn.com.java.mode.observer.demo;

public class Player implements Observer,ObserverAware{
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void help() {
        System.out.println("坚持住，"+this.name+"马上来救援你");
    }

    @Override
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name+"遭受攻击");
        acc.nodifyObserver(this);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
