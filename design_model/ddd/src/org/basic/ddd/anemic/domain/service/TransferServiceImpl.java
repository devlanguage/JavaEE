package org.basic.ddd.anemic.domain.service;

import java.math.BigDecimal;

import org.basic.ddd.anemic.domain.model.Account;
import org.basic.ddd.anemic.domain.model.AccountRepository;
import org.basic.ddd.anemic.domain.model.AccountUnderflowException;
import org.basic.ddd.anemic.domain.model.TransferTransaction;
import org.basic.ddd.anemic.domain.model.TransferTransactionRepository;

public class TransferServiceImpl implements TransferService {
	private AccountRepository accountRepository;
	private TransferTransactionRepository transferTransactionRepository;
	
	public TransferServiceImpl(AccountRepository accountRepository, 
			TransferTransactionRepository transferTransactionRepository) {
		this.accountRepository = accountRepository;
		this.transferTransactionRepository = transferTransactionRepository;
	}
	
	public TransferTransaction transfer(String fromAccountId, String toAccountId,
			BigDecimal amount) throws AccountNotExistedException, AccountUnderflowException {
		Account fromAccount = accountRepository.findAccount(fromAccountId);
		if (fromAccount == null) throw new AccountNotExistedException(fromAccountId);
		Account toAccount = accountRepository.findAccount(toAccountId);
		if (toAccount == null) throw new AccountNotExistedException(toAccountId);
		
		fromAccount.debit(amount);
		toAccount.credit(amount);
		
		accountRepository.updateAccount(fromAccount);	// 对Hibernate来说这不是必须的
		accountRepository.updateAccount(toAccount);		// 对Hibernate来说这不是必须的
		return transferTransactionRepository.create(fromAccountId, toAccountId, amount);
	}
	
}
