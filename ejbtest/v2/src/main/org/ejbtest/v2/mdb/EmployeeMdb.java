package org.ejbtest.v2.mdb;

import java.util.Enumeration;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmployeeMdb implements javax.ejb.MessageDrivenBean, javax.jms.MessageListener {

    private static final long serialVersionUID = 1L;
    private MessageDrivenContext ctx;
    private final static Log logger = LogFactory.getLog(EmployeeMdb.class);

    public EmployeeMdb() {
        super();
        logger.info("EmployeeMdb init");
    }

    public void ejbCreate() {
        logger.info("EmployeeMdb ejbCreate");
        // This method is required, but you
        // don't have to do anything with it
    }

    @Override
    public void ejbRemove() throws EJBException {
        logger.info("EmployeeMdb ejbRemove");
    }

    @Override
    public void setMessageDrivenContext(MessageDrivenContext messagedrivencontext) throws EJBException {
        this.ctx = messagedrivencontext;
    }

    @Override
    public void onMessage(javax.jms.Message msg) {
        // ctx.lookup("");
        logger.info("Received: " + msg);
        try {
            if (msg instanceof javax.jms.TextMessage) {
                javax.jms.TextMessage message = (javax.jms.TextMessage) msg;
                System.out.println("contents: " + message.getText());
            } else if (msg instanceof javax.jms.MapMessage) {
                javax.jms.MapMessage message = (javax.jms.MapMessage) msg;
                for (Enumeration<String> iter = message.getMapNames(); iter.hasMoreElements();) {
                    String name = iter.nextElement();
                    System.out.println("contents: " + name + "=" + message.getObject(name));
                }

            } else if (msg instanceof javax.jms.ObjectMessage) {
                javax.jms.ObjectMessage message = (javax.jms.ObjectMessage) msg;
                System.out.println("contents: " + message.getObject());

            } else if (msg instanceof javax.jms.BytesMessage) {
                javax.jms.BytesMessage message = (javax.jms.BytesMessage) msg;
                byte[] cache = new byte[512];
                System.out.println("contents: " + message.readBytes(cache));

            } else if (msg instanceof javax.jms.StreamMessage) {
                javax.jms.StreamMessage message = (javax.jms.StreamMessage) msg;
                byte[] cache = new byte[512];
                System.out.println("contents: " + message.readBytes(cache));

            }
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
