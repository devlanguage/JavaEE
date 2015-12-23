/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.user.UserServiceLocal.java is created on 2008-7-1
 */
package org.ejbtest.user;

import java.util.List;

import javax.ejb.Local;

import org.ejbtest.user.persistence.User;

/**
 * 
 */
@Local
public interface UserServiceLocal {

    public List<User> listUsers();
}
