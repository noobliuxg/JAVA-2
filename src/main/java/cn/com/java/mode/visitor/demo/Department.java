package cn.com.java.mode.visitor.demo;

public abstract class Department {
    public abstract void visit(FulltimeEmployee employee);
    public abstract void visit(ParttimeEmployee employee);
}
