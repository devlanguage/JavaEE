/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file org.ejbtest.user.UserService.java
 * is created on 2008-7-1
 */
package org.ejbtest.user;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import org.ejbtest.user.persistence.User;

/**
 * 
 */
// @Stateless
@Stateful
@RemoteBinding(jndiBinding = "UserService/remote")
@LocalBinding(jndiBinding = "UserService/local")
public class UserServiceBean implements UserServiceLocal, UserServiceRemote {

    private List<User> users = new ArrayList<User>();

    @javax.ejb.Init
    public void init() {

        System.out.println("User Service: Init");

    }

    @javax.ejb.PostActivate
    public void postActivate() {

        System.out.println("User Service: postActivate");
    }

    @javax.ejb.PrePassivate
    public void prePassivatee() {

        System.out.println("User Service: prePassivatee");

    }

    public User createUser(String name, String password) {

        User u = new User(name, password);
        users.add(u);
        return u;
    }

    public List<User> listUsers() {

        return users;
    }

}
