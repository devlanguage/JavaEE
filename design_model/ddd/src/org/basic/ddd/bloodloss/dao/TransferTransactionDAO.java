package org.basic.ddd.bloodloss.dao;

import java.math.BigDecimal;

import org.basic.ddd.bloodloss.model.TransferTransaction;

public interface TransferTransactionDAO {
    TransferTransaction create(String fromAccountId, String toAccountId, BigDecimal amount);
}
