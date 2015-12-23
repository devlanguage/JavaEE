package org.ejbtest.v2.entity;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface LocalUserInfoHome extends EJBLocalHome {

    public LocalUserInfo create(
                        String firstName, String middleName, 
                        String lastName, String email, 
                        String dept, String workPhone,
                        String extention, String homePhone, 
                        boolean isEmployee)
                                    throws CreateException;
    
    public LocalUserInfo findByPrimaryKey (String email)
                                          throws FinderException;

}