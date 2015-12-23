package org.basic.ddd.anemic.application;

import java.math.BigDecimal;

import org.basic.ddd.anemic.domain.model.Account;
import org.basic.ddd.anemic.domain.model.AccountRepository;
import org.basic.ddd.anemic.domain.model.AccountUnderflowException;
import org.basic.ddd.anemic.domain.model.TransferTransaction;
import org.basic.ddd.anemic.domain.service.AccountNotExistedException;
import org.basic.ddd.anemic.domain.service.TransferService;

public class TransferFacadeImpl implements TransferFacade {

	private AccountRepository accountRepository;
	private TransferService transferService;
	
	public TransferFacadeImpl(AccountRepository accountRepository,
			TransferService transferService) {
		this.accountRepository = accountRepository;
		this.transferService = transferService;
	}
	
	public Account createAccount(String accountId, BigDecimal balance) {
		return accountRepository.createAccount(accountId, balance);
	}

	public TransferTransaction transfer(String fromAccountId,
			String toAccountId, BigDecimal amount)
				throws AccountNotExistedException, AccountUnderflowException {
		return transferService.transfer(fromAccountId, toAccountId, amount);
	}

	public BigDecimal getBalance(String accountId) {
		return accountRepository.findAccount(accountId).getBalance();
	}
	
}
