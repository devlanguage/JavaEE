package org.basic.ddd.anemic.domain.model;

import java.math.BigDecimal;

public interface AccountRepository {
	Account findAccount(String accountId);
	
	Account createAccount(String accountId, BigDecimal balance);
	
	void updateAccount(Account account);
}
