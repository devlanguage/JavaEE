/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.account.service.UserService.java is created on 2008-7-1
 */
package org.ejbtest.account.service;

import org.ejbtest.account.persistence.onetoone.Sex;
import org.ejbtest.account.vo.AccountVo;

/**
 * 
 */
public interface AccountServiceRemote1 {

    String remote1Hello(String client);
    AccountVo createAccount(String name, String address, Sex sex);
}
