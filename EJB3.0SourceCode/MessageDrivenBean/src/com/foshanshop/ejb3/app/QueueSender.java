package com.foshanshop.ejb3.app;

import java.util.Properties;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import com.foshanshop.ejb3.bean.Man;

public class QueueSender {
    public static void main(String[] args) {
        QueueConnection conn = null;
        QueueSession session = null;
        try {
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            props.setProperty("java.naming.provider.url", "localhost:1099");
            props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            InitialContext ctx = new InitialContext(props);
            
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");
            conn = factory.createQueueConnection();
            session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            Destination destination = (Queue) ctx.lookup("queue/foshanshop");
            MessageProducer producer = session.createProducer(destination);
            
            //�����ı�
            TextMessage msg = session.createTextMessage("��ɽ�����ã������ҵĵ�һ����Ϣ����Bean");
            producer.send(msg);
            
            //����Ojbect(�������ʵ�����л�,������ų����)
            producer.send(session.createObjectMessage(new Man("��Ů", "������ƽ��һ��")));
            
            //����MapMessage
            MapMessage mapmsg = session.createMapMessage();
            mapmsg.setObject("no1", "������ƽ��һ��");
            producer.send(mapmsg);
            
            //����BytesMessage
            BytesMessage bmsg = session.createBytesMessage();
            bmsg.writeBytes("����һ����,�����ϰ���".getBytes());
            producer.send(bmsg);
            
            
            //����StreamMessage
            StreamMessage smsg = session.createStreamMessage();
            smsg.writeString("�ҾͰ�����д");
            producer.send(smsg);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                session.close ();
                conn.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
