package org.ejbtest.v2.entity;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface LocalUserHome extends EJBLocalHome {

    public LocalUser create(String email, String password) throws CreateException;
    public LocalUser findByPrimaryKey(String email) throws FinderException;

}