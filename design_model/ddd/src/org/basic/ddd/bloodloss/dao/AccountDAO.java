package org.basic.ddd.bloodloss.dao;

import java.math.BigDecimal;

import org.basic.ddd.bloodloss.model.Account;

public interface AccountDAO {
    Account findAccount(String accountId);

    Account createAccount(String accountId, BigDecimal balance);

    void updateAccount(Account account);

    void clearAccount();
}
