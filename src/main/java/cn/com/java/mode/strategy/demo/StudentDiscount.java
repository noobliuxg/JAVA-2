package cn.com.java.mode.strategy.demo;

import java.math.BigDecimal;

public class StudentDiscount implements Discount{
    @Override
    public BigDecimal calculate(BigDecimal price) {
        System.out.println("学生票 打8折");
        return price.multiply(new BigDecimal(0.8));
    }
}
