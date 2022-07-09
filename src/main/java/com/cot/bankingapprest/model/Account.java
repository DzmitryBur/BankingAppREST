package com.cot.bankingapprest.model;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Account {

    private long id;
    private String iban;
    private long balance;
    private long banks_id;
    private long user_id;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                ", banks_id=" + banks_id +
                ", user_id=" + user_id +
                '}';
    }


    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBanks_id() {
        return banks_id;
    }

    public void setBanks_id(long banks_id) {
        this.banks_id = banks_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}

