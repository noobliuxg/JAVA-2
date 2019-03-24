package cn.com.java.mode.adaptor;

import org.junit.Test;

public class Main {

    @Test
    public void test(){
        FishBoat boat = new FishBoat();
        Captain captain = new Captain(new FishBoatAdaptor(boat));
        captain.row();
    }
}
