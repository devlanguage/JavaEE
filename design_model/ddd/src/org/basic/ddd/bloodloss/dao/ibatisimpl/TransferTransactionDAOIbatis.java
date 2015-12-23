package org.basic.ddd.bloodloss.dao.ibatisimpl;

import java.math.BigDecimal;
import java.util.Date;

import org.basic.ddd.bloodloss.dao.TransferTransactionDAO;
import org.basic.ddd.bloodloss.model.TransferTransaction;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class TransferTransactionDAOIbatis implements TransferTransactionDAO {

	private SqlMapClientTemplate ibatisTemplate;
	
	public TransferTransactionDAOIbatis(com.ibatis.sqlmap.client.SqlMapClient sessionFactory) {
		this.ibatisTemplate = new SqlMapClientTemplate(sessionFactory);
	}
	
	public TransferTransaction create(String fromAccountId, String toAccountId,
			BigDecimal amount) {
		Date timestamp = new Date();
		TransferTransaction transferTransaction = new TransferTransaction(
				fromAccountId, toAccountId, amount, timestamp);
		ibatisTemplate.insert("insertTransferTransaction");
		return transferTransaction;
	}

}
