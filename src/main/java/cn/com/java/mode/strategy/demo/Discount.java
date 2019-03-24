package cn.com.java.mode.strategy.demo;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal calculate(BigDecimal price);
}
