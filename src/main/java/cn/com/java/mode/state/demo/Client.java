package cn.com.java.mode.state.demo;

import java.math.BigDecimal;

public class Client {
    public static void main(String args[]) {
        Account acc = new Account(BigDecimal.ZERO,"段誉");
        acc.deposit(new BigDecimal(1000));
        acc.withdraw(new BigDecimal(2000));
        acc.deposit(new BigDecimal(3000));
        acc.withdraw(new BigDecimal(4000));
        acc.withdraw(new BigDecimal(1000));
        acc.computeInterest();
    }
}
