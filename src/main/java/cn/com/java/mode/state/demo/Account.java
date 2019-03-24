package cn.com.java.mode.state.demo;

import java.math.BigDecimal;

public class Account {
    private AccountState state;

    private BigDecimal balance;

    private String owner;

    public Account(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
        this.state = new NormalState(this);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal balance){
        System.out.println(this.owner+"存款"+balance);
        this.state.deposit(balance);
        System.out.println("现在余额为"+ this.balance);
        System.out.println("现在帐户状态为"+ this. state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    public void withdraw(BigDecimal balance){
        System.out.println(this.owner+"取款"+balance);
        this.state.withdraw(balance);
        System.out.println("现在余额为"+ this.balance);
        System.out.println("现在帐户状态为"+ this. state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    /**
     * 计算利息
     */
    public void computeInterest(){
        state.computeInterest();
    }
}
