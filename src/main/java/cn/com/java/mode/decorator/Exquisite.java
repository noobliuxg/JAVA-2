package cn.com.java.mode.decorator;

public class Exquisite extends ModifyHouse {

    public Exquisite(House house) {
        super(house);
    }

    @Override
    public void stop() {
        System.out.print("精装修的房子，不仅");
        this.house.stop();
        System.out.println(",还能让人住的更舒服");
    }
}
