package cn.com.java.mode.state.demo;

import java.math.BigDecimal;

public class NormalState extends AccountState{

    public NormalState(Account account) {
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
        if (account.getBalance().compareTo(new BigDecimal(-2000L)) > 0 && account.getBalance().compareTo(BigDecimal.ZERO) <= 0) {
            account.setState(new OverdraftState(this.account));
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
        System.out.println("正常状态，无须支付利息！");
    }
}
