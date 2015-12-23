package org.basic.ddd.anemic.domain.model;

import java.math.BigDecimal;

public interface TransferTransactionRepository {
	TransferTransaction create(String fromAccountId, String toAccountId, BigDecimal amount);
}
