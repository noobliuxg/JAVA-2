package cn.com.java.mode.prototype;

import java.io.Serializable;

public class Prototype extends Object implements Cloneable, Serializable {
    private int field_int;
    private String field_str;

    public int getField_int() {
        return field_int;
    }

    public void setField_int(int field_int) {
        this.field_int = field_int;
    }

    public String getField_str() {
        return field_str;
    }

    public void setField_str(String field_str) {
        this.field_str = field_str;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "field_int=" + field_int +
                ", field_str='" + field_str + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
