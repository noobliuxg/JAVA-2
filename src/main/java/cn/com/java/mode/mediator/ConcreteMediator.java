package cn.com.java.mode.mediator;

public class ConcreteMediator extends Mediator {
    public List list;
    public TextBox userNameTextBox;
    public ComboBox cb;

    //维持对各个同事对象的引用
    public Button addButton;

    public ConcreteMediator(List list, TextBox userNameTextBox, ComboBox cb, Button addButton) {
        this.list = list;
        this.userNameTextBox = userNameTextBox;
        this.cb = cb;
        this.addButton = addButton;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setUserNameTextBox(TextBox userNameTextBox) {
        this.userNameTextBox = userNameTextBox;
    }

    public void setCb(ComboBox cb) {
        this.cb = cb;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    //封装同事对象之间的交互
    @Override
    public void componentChanged(Component c) {
        //单击按钮
        if (c == addButton) {
            System.out.println("--单击增加按钮--");
            list.update();
            cb.update();
            userNameTextBox.update();
        }
        //从列表框选择客户
        else if (c == list) {
            System.out.println("--从列表框选择客户--");
            cb.select();
            userNameTextBox.setText();
        }
        //从组合框选择客户
        else if (c == cb) {
            System.out.println("--从组合框选择客户--");
            cb.select();
            userNameTextBox.setText();
        }
    }
}
