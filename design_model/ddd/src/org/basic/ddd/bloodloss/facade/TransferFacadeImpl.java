package org.basic.ddd.bloodloss.facade;

import java.math.BigDecimal;

import org.basic.ddd.bloodloss.exceptions.AccountNotExistedException;
import org.basic.ddd.bloodloss.exceptions.AccountUnderflowException;
import org.basic.ddd.bloodloss.model.Account;
import org.basic.ddd.bloodloss.model.TransferTransaction;
import org.basic.ddd.bloodloss.service.TransferService;

public class TransferFacadeImpl implements TransferFacade {

    private TransferService transferService;

    public TransferFacadeImpl(TransferService transferService) {
        this.transferService = transferService;
    }

    public Account createAccount(String accountId, BigDecimal balance) {
        return transferService.createAccount(accountId, balance);
    }

    public TransferTransaction transfer(String fromAccountId, String toAccountId, BigDecimal amount)
            throws AccountNotExistedException, AccountUnderflowException {
        return transferService.transfer(fromAccountId, toAccountId, amount);
    }

    public BigDecimal getBalance(String accountId) {
        return transferService.getBalance(accountId);
    }

    @Override
    public void clearAccount() {
        transferService.clearAccount();
        
    }
}
