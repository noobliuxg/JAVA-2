package cn.com.java.mode.interpreter;

public class SentenceNode extends AbstractNode{
    private AbstractNode direction;
    private AbstractNode action;
    private AbstractNode distance;

    public SentenceNode(AbstractNode direction, AbstractNode action, AbstractNode distance) {
        this.direction = direction;
        this.action = action;
        this.distance = distance;
    }

    @Override
    public String interpret() {
        return this.direction.interpret()+this.action.interpret()+this.distance.interpret();
    }
}
