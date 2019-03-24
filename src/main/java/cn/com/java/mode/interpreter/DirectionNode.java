package cn.com.java.mode.interpreter;


public class DirectionNode extends AbstractNode{

    private String direction;

    public DirectionNode(String direction) {
        this.direction = direction;
    }

    @Override
    public String interpret() {
        switch (direction){
            case "up":
                return "向上";
            case "left":
                return "向左";
            case "down":
                return "向下";
            case "right":
                return "向右";
        }
        return "无效指令";
    }
}
