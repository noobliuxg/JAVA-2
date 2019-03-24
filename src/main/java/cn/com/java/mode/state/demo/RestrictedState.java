package cn.com.java.mode.state.demo;

import java.math.BigDecimal;

public class RestrictedState extends AccountState{
    public RestrictedState(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(BigDecimal amount) {
        this.account.setBalance(this.account.getBalance().add(amount));
        stateCheck();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        System.out.println("帐号受限，取款失败");
    }

    @Override
    public void stateCheck() {
        if(account.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            account.setState(new NormalState(this.account));
        }
        else if(account.getBalance().compareTo(new BigDecimal(-2000)) > 0) {
            account.setState(new OverdraftState(this.account));
        }
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }
}
