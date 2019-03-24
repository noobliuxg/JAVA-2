package cn.com.java.mode.observer.demo;

public class IgAllyControlCenter extends AllyControlCenter{

    public IgAllyControlCenter(String allyName) {
        super(allyName);
    }

    @Override
    public void nodifyObserver(Observer observer) {
        for (Observer player : players){
            if (player == observer)
                continue;
            player.help();
        }
    }
}
