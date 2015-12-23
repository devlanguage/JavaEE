package org.basic.ddd.bloodloss.dao.hibernateimpl;

import java.math.BigDecimal;
import java.util.List;

import org.basic.ddd.bloodloss.dao.AccountDAO;
import org.basic.ddd.bloodloss.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class AccountDAOHibernate implements AccountDAO {
    private HibernateTemplate hibernateTemplate;

    public AccountDAOHibernate(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public Account createAccount(String accountId, BigDecimal balance) {
        System.out.println("hibernate create account");
        Account account = new Account(accountId, balance);
        hibernateTemplate.save(account);
        return account;
    }

    @SuppressWarnings("unchecked")
    public Account findAccount(String accountId) {
        List accounts = hibernateTemplate.findByNamedQuery("Account.findByAccountId", accountId);
        return accounts.isEmpty() ? null : (Account) accounts.get(0);
    }

    public void updateAccount(Account account) {
        System.out.println("hibernate update account");
        hibernateTemplate.update(account);
    }

    @Override
    public void clearAccount() {
//        hibernateTemplate.bulkUpdate("delete from Account");
        
    }
}
