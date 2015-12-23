package org.basic.ddd.anemic.domain.model;

import java.math.BigDecimal;

public interface OverdraftPolicy {
	boolean isAllowed(Account account, BigDecimal amount);
}
