/**
 * The file org.ejbtest.communication.service.mail.MailService.java was created by yongjie.gong on 2008-7-2
 */
package org.ejbtest.communication.service.mail;

import javax.annotation.Resource;

import org.ejbtest.communication.persistence.Mail;

/**
 * @author feiye
 * 
 */
public class MailService {

    @Resource(mappedName = "java:/Mail")
    javax.mail.Session session;

    public boolean sendMail(Mail mail) {

        System.out.println("MailService:" + session);
        System.out.println(mail);
        return false;
    }

}
