package cn.com.java.mode.observer.demo;

import java.util.ArrayList;
import java.util.List;

public abstract class AllyControlCenter {

    protected String allyName; //战队名称
    protected List<Observer> players = new ArrayList<>(); //定义一个集合用于存储战队成员

    public AllyControlCenter(String allyName) {
        this.allyName = allyName;
    }

    public void join(Observer observer){
        System.out.println(observer.getName()+"加入到"+allyName);
        players.add(observer);
    }

    public void quit(Observer observer){
        System.out.println(observer.getName()+"从队伍中退出");
        players.remove(observer);
    }

    public abstract void nodifyObserver(Observer observer);
}
