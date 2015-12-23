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

            // 发送文本
            TextMessage msg = session.createTextMessage("佛山人您好，这是我的第一个消息驱动Bean");
            producer.send(msg);

            // 发送Ojbect(对像必须实现序列化,否则等着出错吧)
            producer.send(session.createObjectMessage(new Man("美女", "北京和平里一号")));

            // 发送MapMessage
            MapMessage mapmsg = session.createMapMessage();
            mapmsg.setObject("no1", "北京和平里一号");
            producer.send(mapmsg);

            // 发送BytesMessage
            BytesMessage bmsg = session.createBytesMessage();
            bmsg.writeBytes("我是一个兵,来自老百姓".getBytes());
            producer.send(bmsg);

            // 发送StreamMessage
            StreamMessage smsg = session.createStreamMessage();
            smsg.writeString("我就爱流读写");
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
