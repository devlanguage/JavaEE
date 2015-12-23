package org.basic.ddd.anemic.domain.service;

import java.math.BigDecimal;

import org.basic.ddd.anemic.domain.model.AccountUnderflowException;
import org.basic.ddd.anemic.domain.model.TransferTransaction;

public interface TransferService {
	TransferTransaction transfer(String fromAccountId, String toAccountId, BigDecimal amount) 
			throws AccountNotExistedException, AccountUnderflowException;
}
