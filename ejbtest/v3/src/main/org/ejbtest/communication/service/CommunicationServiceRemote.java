/**
 * The file org.ejbtest.communication.service.CommunicationServiceRemote.java was created by yongjie.gong on 2008-7-2
 */
package org.ejbtest.communication.service;

import org.ejbtest.communication.persistence.Mail;

/**
 * @author feiye
 * 
 */
public interface CommunicationServiceRemote {

    public void sendMail(Mail mail);
}
