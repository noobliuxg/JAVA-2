package cn.com.java.mode.observer.demo;

interface Observer {
    String getName();
    void help(); //声明支援盟友方法
    void beAttacked(AllyControlCenter acc); //声明遭受攻击方法  
}
