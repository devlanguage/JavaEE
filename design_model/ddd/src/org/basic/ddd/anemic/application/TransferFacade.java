package org.basic.ddd.anemic.application;

import java.math.BigDecimal;

import org.basic.ddd.anemic.domain.model.Account;
import org.basic.ddd.anemic.domain.model.AccountUnderflowException;
import org.basic.ddd.anemic.domain.model.TransferTransaction;
import org.basic.ddd.anemic.domain.service.AccountNotExistedException;

public interface TransferFacade {
	TransferTransaction transfer(String fromAccountId, String toAccountId, BigDecimal amount) 
			throws AccountNotExistedException, AccountUnderflowException;
	
	Account createAccount(String accountId, BigDecimal balance);
	
	BigDecimal getBalance(String accountId);
}
