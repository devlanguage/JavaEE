/**
 * The file org.ejbtest.test.mail.Service.MailServiceTester.java was created by yongjie.gong on 2008-7-2
 */
package org.ejbtest.communication.service;

import org.ejbtest.JndiUtil;
import org.ejbtest.communication.persistence.Mail;

/**
 * @author feiye
 * 
 */
public class CommunicationServiceTester {

    public static void main(String[] args) {

        testStateful();
    }

    final static void testStateful() {

        CommunicationServiceRemote csr = (CommunicationServiceRemote) JndiUtil.getEJB("CommunicationService/remote");
        Mail mail = new Mail();
        mail.setSender("ZhangSan");
        
        mail.setHeader("Hello");
        mail.setBody("hello world");
        csr.sendMail(mail);

    }
}
