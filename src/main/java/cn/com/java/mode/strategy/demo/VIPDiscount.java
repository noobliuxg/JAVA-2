package cn.com.java.mode.strategy.demo;

import java.math.BigDecimal;

public class VIPDiscount implements Discount{
    @Override
    public BigDecimal calculate(BigDecimal price) {
        System.out.println("VIP 打5折,并且可以累计积分");
        return price.multiply(new BigDecimal(0.5));
    }
}
