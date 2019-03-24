package cn.com.java.mode.interpreter;

public class ActionNode extends AbstractNode{
    private String action;

    public ActionNode(String action) {
        this.action = action;
    }

    @Override
    public String interpret() {
        switch (action){
            case "move":
                return "移动";
            case "run":
                return "快速移动";
        }
        return "无效指令";
    }
}
