package cn.com.java.mode.strategy.demo;

import java.math.BigDecimal;

public class ChildrenDiscount implements Discount{

    @Override
    public BigDecimal calculate(BigDecimal price) {
        System.out.println("小孩票，减10元");
        if (price.compareTo(new BigDecimal(20))>0)
            return price.subtract(new BigDecimal(10));
        return price;
    }
}
