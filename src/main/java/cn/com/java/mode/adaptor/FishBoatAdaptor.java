package cn.com.java.mode.adaptor;


public class FishBoatAdaptor implements RowingBoat{
    private FishBoat boat;

    public FishBoatAdaptor(FishBoat boat) {
        this.boat = boat;
    }

    @Override
    public void row() {
        boat.sail();
    }
}
