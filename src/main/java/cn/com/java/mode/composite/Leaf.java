package cn.com.java.mode.composite;

public class Leaf extends Component{

    @Override
    public void add(Component component) {
        throw new RuntimeException("叶子节点不能添加子节点");
    }

    @Override
    public void remove(Component component) {
        throw new RuntimeException("叶子节点没有子节点不能删除");
    }

    @Override
    public Component getChild(int i) {
        throw new RuntimeException("叶子节点只有一个节点没有子节点");
    }

    @Override
    public void operation() {
        System.out.println("修改/添加/删除叶子节点的内容");
    }
}
