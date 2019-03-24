package cn.com.java.thread.lock;

public class PessimisticLock {

    public static void main(String[] args) {
        Goods goods1 = UpdateUtils.select(2);
        Goods goods2 = UpdateUtils.select(2);

        goods1.setStatus(3);
        int pes = UpdateUtils.updatePes(goods1);
        System.out.println("修改商品信息1"+(pes==1?"成功":"失败"));
        goods2.setStatus(3);
        pes = UpdateUtils.updatePes(goods2);
        System.out.println("修改商品信息2"+(pes==1?"成功":"失败"));

    }
}
