package cn.com.java.mode.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

    private List<Component> lists = new ArrayList<>();

    @Override
    public void add(Component component) {
        lists.add(component);
    }

    @Override
    public void remove(Component component) {
        lists.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return lists.get(i);
    }

    @Override
    public void operation() {
        throw new RuntimeException("不能修改容器的内容只能修改容器中的节点数");
    }
}
