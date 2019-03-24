package cn.com.java.mode.decorator;

public abstract class ModifyHouse implements House{
    protected House house;

    public ModifyHouse(House house){
        this.house = house;
    }

}
