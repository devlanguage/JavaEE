/**
 * The file org.ejbtest.test.jms.service.JmsServiceTester.java was created by yongjie.gong on 2008-7-2
 */
package org.ejbtest.test.jms.service;

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

import org.ejbtest.jms.bean.Man;
import org.ejbtest.test.EjbFactory;

/**
 * @author feiye
 * 
 */
public class JmsServiceTester {

    public static void main(String[] args) {

        testJms();
    }

    static void testJms() {

        // javax.jms.TopicConnectionFactory o =
        // (TopicConnectionFactory)EjbFactory.getEJB("TopicConnectionFactory");
        javax.jms.QueueConnectionFactory qf = (QueueConnectionFactory) EjbFactory.getEJB("QueueConnectionFactory");
        javax.jms.Connection conn = null;
        javax.jms.Session session = null;

        javax.jms.Queue queueA = (javax.jms.Queue) EjbFactory.getEJB("queue/A1");
        MessageConsumer consumer;
        try {
            conn = qf.createConnection();
            // conn.start();
            session = conn.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);

            consumer = session.createConsumer(queueA);
            consumer.setMessageListener(new MessageListener() {

                public void onMessage(Message arg0) {

                    System.out.println(arg0);
                }

            });
        } catch (JMSException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        MessageProducer producer;
        try {

            producer = session.createProducer(queueA);

            // �����ı�
            TextMessage msg = session.createTextMessage("��ɽ�����ã������ҵĵ�һ����Ϣ����Bean");
            producer.send(msg);

            // ����Ojbect(�������ʵ�����л�,������ų����)
            producer.send(session.createObjectMessage(new Man("��Ů", "������ƽ��һ��")));

            // ����MapMessage
            MapMessage mapmsg = session.createMapMessage();
            mapmsg.setObject("no1", "������ƽ��һ��");
            producer.send(mapmsg);

            // ����BytesMessage
            BytesMessage bmsg = session.createBytesMessage();
            bmsg.writeBytes("����һ����,�����ϰ���".getBytes());
            producer.send(bmsg);

            // ����StreamMessage
            StreamMessage smsg = session.createStreamMessage();
            smsg.writeString("�ҾͰ�����д");
            producer.send(smsg);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                session.close();
                conn.close();
            } catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}
