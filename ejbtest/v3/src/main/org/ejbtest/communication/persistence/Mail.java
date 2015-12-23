/**
 * The file org.ejbtest.communication.persistence.Mail.java was created by yongjie.gong on 2008-7-2
 */
package org.ejbtest.communication.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feiye
 * 
 */
public class Mail implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3597695459414119013L;
    private String sender;
    private List<String> recipients;
    private String header;
    private String body;

    public String getBody() {

        return body;
    }

    public void setBody(String body) {

        this.body = body;
    }

    public String getHeader() {

        return header;
    }

    public void setHeader(String header) {

        this.header = header;
    }

    public List<String> getRecipients() {

        if (this.recipients == null) {
            recipients = new ArrayList<String>();
        }

        return recipients;
    }

    public void setRecipients(List<String> recipients) {

        this.recipients = recipients;
    }

    public String getSender() {

        return sender;
    }

    public void setSender(String sender) {

        this.sender = sender;
    }

    @Override
    public String toString() {

        return new StringBuffer(this.getClass().getSimpleName()).append(":[sender=").append(this.sender).append(
                ", recipients=").append(this.recipients).append(", header=").append(this.header).toString();
    }
}
