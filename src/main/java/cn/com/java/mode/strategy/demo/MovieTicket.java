package cn.com.java.mode.strategy.demo;

import java.math.BigDecimal;

public class MovieTicket {
    private BigDecimal price;
    private Discount discount;

    public MovieTicket(BigDecimal price) {
        this.price = price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice(){
        return discount.calculate(price);
    }

}
