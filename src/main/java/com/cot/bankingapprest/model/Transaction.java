package com.cot.bankingapprest.model;


import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Transaction {

    private long id;
    private long amount;
    private Timestamp date;
    private long id_accounts;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", id_accounts=" + id_accounts +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public long getId_accounts() {
        return id_accounts;
    }

    public void setId_accounts(long id_accounts) {
        this.id_accounts = id_accounts;
    }


}


