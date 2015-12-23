package org.basic.ddd.bloodloss.service;

import java.math.BigDecimal;

import org.basic.ddd.bloodloss.exceptions.AccountNotExistedException;
import org.basic.ddd.bloodloss.exceptions.AccountUnderflowException;
import org.basic.ddd.bloodloss.model.Account;
import org.basic.ddd.bloodloss.model.TransferTransaction;

public interface TransferService {
    TransferTransaction transfer(String fromAccountId, String toAccountId, BigDecimal amount)
            throws AccountNotExistedException, AccountUnderflowException;

    Account createAccount(String accountId, BigDecimal balance);

    BigDecimal getBalance(String accountId);

    void clearAccount();
}
