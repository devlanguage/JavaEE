/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.account.service.AccountService.java is created on 2008-7-1
 */
package org.ejbtest.account.service;

import javax.ejb.TransactionAttributeType;

import org.ejbtest.account.persistence.query.Account;


/**
 * 
 */
public interface AccountServiceLocal {

    public void localHello(String guest, int number);
    //TransactionAttributeType.MANDATORY
    public void tx00_Mandatory(); //If no tx now, Throws Exception
    public void tx01_Required();//If have Tx, Join; Else,  create new Tx
    public void tx02_Require_New(); //Suspend Current Tx, Create new Tx
    public void tx03_Supports();//if have Tx, join; Else, execute in non-Tx 
    public void tx04_Not_Supported();//Suspend Current Tx, Execute in non-Tx
    public void tx05_Never();//If in tx now, Throws Exception
}
