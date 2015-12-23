package org.basic.ddd.bloodloss.model;

import java.math.BigDecimal;

public class Account {
    @SuppressWarnings("unused")
    private long id; /* for hibernate */

    private String accountId;
    private BigDecimal balance;
    private String accountName = "test1";

    public String getName() {
        return accountName;
    }

    public void setName(String name) {
        this.accountName = name;
    }

    public Account() {
    }

    public Account(String accountId, BigDecimal balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String toString() {
        return accountId;
    }
}
