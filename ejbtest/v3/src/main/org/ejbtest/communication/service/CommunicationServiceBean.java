/**
 * The file org.ejbtest.communication.service.CommunicationServiceBean.java was created by yongjie.gong on 2008-7-2
 */
package org.ejbtest.communication.service;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import org.ejbtest.communication.persistence.Mail;
import org.ejbtest.communication.service.interceptor.CommunicationServiceInterceptor;
import org.ejbtest.communication.service.mail.MailService;
import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.ejb.RemoteBinding;
import org.jboss.annotation.ejb.RemoteBindings;

/**
 * @author feiye
 * 
 */
@Stateful
@Local(CommunicationServiceLocal.class)
@LocalBinding(jndiBinding = "Communication/local")
@Remote(CommunicationServiceRemote.class)
@RemoteBindings( { @RemoteBinding(jndiBinding = "CommunicationService/remote") })

@Interceptors({CommunicationServiceInterceptor.class})
public class CommunicationServiceBean implements CommunicationServiceLocal, CommunicationServiceRemote {

    @Resource(mappedName = "java:/Mail")
    javax.mail.Session session;

    private MailService getMailService() {

        return new MailService();
    }

    public void sendMail(Mail mail) {

        MailService mailService = getMailService();
        System.out.println("CommunicationServiceBean: " + session);
        mailService.sendMail(mail);
    }

}
