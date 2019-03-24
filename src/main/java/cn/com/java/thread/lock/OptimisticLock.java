package cn.com.java.thread.lock;

public class OptimisticLock {

    public static void main(String[] args) {
        Goods goods1 = UpdateUtils.select(1);
        Goods goods2 = UpdateUtils.select(1);
        System.out.println(goods1);
        System.out.println(goods2);

        goods1.setStatus(2);
        int updateResult1 = UpdateUtils.updateOptByVersion(goods1);
        System.out.println("修改商品信息1"+(updateResult1==1?"成功":"失败"));

        goods2.setStatus(2);
        int updateResult2 = UpdateUtils.updateOptByVersion(goods2);
        System.out.println("修改商品信息2"+(updateResult2==1?"成功":"失败"));
        System.out.println(System.currentTimeMillis());


        Goods goods3 = UpdateUtils.select(2);
        Goods goods4 = UpdateUtils.select(2);
        System.out.println(goods3);
        System.out.println(goods4);

        goods3.setStatus(2);
        int updateResult3 = UpdateUtils.updateOptByTimestamp(goods3);
        System.out.println("修改商品信息3"+(updateResult3==1?"成功":"失败"));

        goods4.setStatus(2);
        int updateResult4 = UpdateUtils.updateOptByTimestamp(goods4);
        System.out.println("修改商品信息4"+(updateResult4==1?"成功":"失败"));
    }

}
