package cn.com.java.mode.state.demo;

import java.math.BigDecimal;

public class OverdraftState extends AccountState{
    public OverdraftState(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(BigDecimal amount) {
        this.account.setBalance(this.account.getBalance().add(amount));
        this.stateCheck();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        this.account.setBalance(this.account.getBalance().subtract(amount));
        this.stateCheck();
    }

    @Override
    public void stateCheck() {
        if (this.account.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            account.setState(new NormalState(this.account));
        }
        else if (account.getBalance().compareTo(new BigDecimal(-2000)) == 0) {
            account.setState(new RestrictedState(this.account));
        }
        else if (account.getBalance().compareTo(new BigDecimal(-2000)) < 0) {
            System.out.println("操作受限！");
        }
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息");
    }
}
