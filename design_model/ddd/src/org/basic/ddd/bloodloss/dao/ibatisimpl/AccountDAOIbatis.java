package org.basic.ddd.bloodloss.dao.ibatisimpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.basic.ddd.bloodloss.dao.AccountDAO;
import org.basic.ddd.bloodloss.model.Account;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;

public class AccountDAOIbatis implements AccountDAO {
    SqlMapClientTemplate ibatisTemplate;
    public AccountDAOIbatis(SqlMapClient sqlMapClientFactory) {
        this.ibatisTemplate = new SqlMapClientTemplate(sqlMapClientFactory);
    }

    public Account createAccount(String accountId, BigDecimal balance) {
        Account account = new Account(accountId, balance);
        ibatisTemplate.insert("insertAccountByParameterClass",account);
        
        System.out.println("\n\n\n\n\n");
        Map<String,String> accoutAttr = new HashMap<String,String>();
        accoutAttr.put("accountID", "");
        accoutAttr.put("accountName", "");
        ibatisTemplate.insert("insertAccountByParameterMap",accoutAttr);
        return account;
    }

    @SuppressWarnings("unchecked")
    public Account findAccount(String accountId) {
        List accounts = ibatisTemplate.queryForList("findByAccountId", accountId);
        return accounts.isEmpty() ? null : (Account) accounts.get(0);
    }

    public void updateAccount(Account account) {
        ibatisTemplate.update("updateAccount");
    }

    @Override
    public void clearAccount() {
        ibatisTemplate.delete("deleteAllAccount");
        
    }
}
