package cn.com.java.mode.state.demo;

import java.math.BigDecimal;

public abstract class AccountState {
    protected Account account;

    public abstract void deposit(BigDecimal amount);

    public abstract void withdraw(BigDecimal amount);

    public abstract void stateCheck();

    public abstract void computeInterest();
}
