/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.test.account.service.AccountServiceTester.java is created on 2008-7-1
 */
package org.ejbtest.test.account.service;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.QueueConnectionFactory;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.ejbtest.account.service.AccountServiceLocal;
import org.ejbtest.account.service.AccountServiceRemote1;
import org.ejbtest.jms.bean.Man;
import org.ejbtest.test.EjbFactory;
import org.ejbtest.user.UserServiceRemote;

/**
 * 
 */
public class AccountServiceTester {

    public static void main(String[] args) {

        testSessionBean();
    }

    static void testSessionBean() {

        org.jboss.security.SecurityAssociation.setPrincipal(new org.jboss.security.SimplePrincipal("testUser".trim()));
        org.jboss.security.SecurityAssociation.setCredential("password".trim().toCharArray());

        AccountServiceLocal accountServiceRemote1 = (AccountServiceLocal) EjbFactory.getEJB("AccountService/remote1");
        accountServiceRemote1.hello("ygongjie", 100);

        UserServiceRemote userServiceRemote = (UserServiceRemote) EjbFactory.getEJB("UserService/remote");
        userServiceRemote.createUser("zhangsan", "password-1");

        AccountServiceRemote1 accountServiceRemote2 = (AccountServiceRemote1) EjbFactory.getEJB("AccountService/remote2");
        accountServiceRemote2.listUsers();

        // for (int i = 0; i < 10; i++) {
        // helloRemote.hello("Zhangsan", i);
        // }
    }

}
