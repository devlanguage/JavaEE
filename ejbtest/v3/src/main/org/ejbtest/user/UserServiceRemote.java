/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file org.ejbtest.user.UserService.java
 * is created on 2008-7-1
 */
package org.ejbtest.user;

import javax.ejb.Remote;

import org.ejbtest.user.persistence.User;

/**
 * 
 */
@Remote
public interface UserServiceRemote {

    public User createUser(String name, String password);

}
