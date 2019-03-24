package cn.com.java.mode.adaptor;

/**
 * 队长划划艇
 *      但是现在没有划艇，只有渔船，这时就需要一个适配器类了
 */
public class Captain implements RowingBoat{

    private RowingBoat boat;

    public Captain(RowingBoat boat) {
        this.boat = boat;
    }

    @Override
    public void row(){
        boat.row();
    }
}
