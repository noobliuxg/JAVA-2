package cn.com.java.thread.lock;

import java.io.Serializable;

public class Goods implements Serializable {
    private static final long serialVersionUID = 6803791908148880587L;
    /**
     * id:主键id.
     */
    private int id;

    /**
     * status:商品状态：1未下单、2已下单.
     */
    private int status;

    /**
     * name:商品名称.
     */
    private String name;

    /**
     * version:商品数据版本号.
     */
    private int version;

    private long timeUnit;


    public long getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(long timeUnit) {
        this.timeUnit = timeUnit;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", timeUnit=" + timeUnit +
                '}';
    }
}
