package org.ejbtest.v2;

import java.util.Hashtable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.NamingException;

import org.apache.derby.impl.sql.compile.HashTableNode;
import org.ejbtest.v2.entity.Employee;
import org.ejbtest.v2.entity.EmployeeHome;
import org.ejbtest.v2.stateless.EmployeeService;
import org.ejbtest.v2.stateless.EmployeeServiceHome;
import org.j2eetest.bean.AppServer;

public class EmployeeV2Test {
    final static javax.naming.Context ctx = JndiUtil.getInitContext(AppServer.JBoss);

    public static void main(String[] args) {
        try {
            Hashtable hs= ctx.getEnvironment();
            System.out.println(hs);
            
            for (javax.naming.NamingEnumeration iter = ctx.list(""); iter.hasMoreElements();) {
                System.out.println(iter.next());

            }
            testMessageDrivenBean();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final static void testSessionBean() {
        try {
            EmployeeServiceHome home = (EmployeeServiceHome) ctx.lookup("EmployeeService");
            EmployeeService employeeService = home.create();
            String employeeName = employeeService.createEmployee("zhangsan");
            System.out.println("Create employee: " + employeeName);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public final static void testEntityBean() {
        try {

            EmployeeHome employeeHome = (EmployeeHome) ctx.lookup("ejb/Employee/remote");
            Employee employee1 = employeeHome.create();
            String employee = employee1.printDetail();
            System.out.println("Create employee: " + employee);

            ctx.lookup("local/ejb/EmployeeMdb/remote@4212265");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public final static void testMessageDrivenBean() throws NamingException, JMSException {
        // jboss.jms
        //
        // alias=QueueConnectionFactory
        // alias=TopicConnectionFactory
        QueueConnectionFactory qcf = null;
        try {
            qcf = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");
            javax.jms.QueueConnection qc = qcf.createQueueConnection();
            javax.jms.QueueSession qs = qc.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            javax.jms.Destination queueA = (Destination) ctx.lookup("queue/A");
            javax.jms.MessageProducer mp = qs.createProducer(queueA);

            javax.jms.Message msg = qs.createTextMessage("testMessage");
            mp.send(msg);

            javax.jms.MapMessage mapMsg = qs.createMapMessage();
            mapMsg.setStringProperty("m1", "setStringProperty");
            mapMsg.setIntProperty("m2", 12);
            mapMsg.setString("m1", "setString");
            mapMsg.setObject("m3", "ObjectString");
            mp.send(mapMsg);

            javax.jms.ObjectMessage objectMsg = qs.createObjectMessage("ocntent");
            objectMsg.setObjectProperty("m1", "setString");
            objectMsg.setStringProperty("m2", "setStringProperty");
            objectMsg.setObject("setObject:zhangsan");
            mp.send(objectMsg);
            qs.close();
            qc.close();
        } finally {
        }

    }
}
