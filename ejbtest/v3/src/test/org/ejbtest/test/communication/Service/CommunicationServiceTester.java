/**
 * The file org.ejbtest.test.mail.Service.MailServiceTester.java was created by yongjie.gong on 2008-7-2
 */
package org.ejbtest.test.communication.Service;

import org.ejbtest.communication.persistence.Mail;
import org.ejbtest.communication.service.CommunicationServiceRemote;
import org.ejbtest.test.EjbFactory;

/**
 * @author feiye
 * 
 */
public class CommunicationServiceTester {

    public static void main(String[] args) {

        testStateful();
    }

    final static void testStateful() {

        CommunicationServiceRemote csr = (CommunicationServiceRemote) EjbFactory.getEJB("CommunicationService/remote");
        Mail mail = new Mail();
        mail.setSender("ZhangSan");
        
        mail.setHeader("Hello");
        mail.setBody("hello world");
        csr.sendMail(mail);

    }
}
