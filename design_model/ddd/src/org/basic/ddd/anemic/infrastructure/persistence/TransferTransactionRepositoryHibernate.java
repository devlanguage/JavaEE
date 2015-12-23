package org.basic.ddd.anemic.infrastructure.persistence;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import org.basic.ddd.anemic.domain.model.TransferTransaction;
import org.basic.ddd.anemic.domain.model.TransferTransactionRepository;

public class TransferTransactionRepositoryHibernate implements TransferTransactionRepository{

	private HibernateTemplate hibernateTemplate;
	
	public TransferTransactionRepositoryHibernate(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public TransferTransaction create(String fromAccountId, String toAccountId,
			BigDecimal amount) {
		Date timestamp = new Date();
		TransferTransaction transferTransaction = new TransferTransaction(
				fromAccountId, toAccountId, amount, timestamp);
		hibernateTemplate.save(transferTransaction);
		return transferTransaction;
	}

}
