/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.test.account.service.EjbFactory.java is created on 2008-7-1
 */
package org.ejbtest;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.j2eetest.bean.AppServer;
import org.j2eetest.util.LoggerUtil;

/**
 * 
 */

public class JndiUtil {
    LoggerUtil logger = LoggerUtil.getLogger(JndiUtil.class);

    // EjbFactory.getEJB("java:/ConnectionFactory");

    // javax.jms.ConnectionFactory cf = (ConnectionFactory) EjbFactory.getEJB("ConnectionFactory");
    // javax.jms.TopicConnectionFactory tf = (TopicConnectionFactory) EjbFactory.getEJB("TopicConnectionFactory");
    // javax.jms.QueueConnectionFactory qf = (QueueConnectionFactory) EjbFactory.getEJB("QueueConnectionFactory");
    private final static Map<String, javax.naming.InitialContext> CTX_MAP = new Hashtable<String, InitialContext>();
    public static javax.naming.Context getInitContext(AppServer server) {
        Properties props = new Properties();
        switch (server) {
            case GlassFish:
                //javaee.jar和appserv-rt.jar，
                //java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory
                props.setProperty("org.omg.CORBA.ORBInitialHost", "glassfish运行的IP地址");
                break;
            case JBoss: {
                props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
                // props.setProperty("java.naming.provider.url", "192.168.0.149:1099,192.168.0.60,192.168.0.51:1099");
                props.setProperty("java.naming.provider.url", "localhost:1099");
                props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
                break;
            }
            case Tomcat:
                break;
            default:
                break;
        }

        javax.naming.InitialContext ctx = null;
        try {
            ctx = new javax.naming.InitialContext(props);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return ctx;
    }

    public static Object getEJB(String jndipath) {

        try {
            Properties props = new Properties();

            // java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory
            // java.naming.factory.url.pkgs=org.jboss.naming:org.jnp.interfaces

            props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            // props.setProperty("java.naming.provider.url",
            // "192.168.0.149:1099,192.168.0.60,192.168.0.51:1099");
            props.setProperty("java.naming.provider.url", "localhost:1099");
            props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            // props.setProperty("jnp.disableDiscovery", "true");
            //         
            // props.setProperty("java.naming.factory.initial",
            // "com.sun.enterprise.naming.SerialInitContextFactory");
            // props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            // props.setProperty("java.naming.provider.url", "192.168.0.251:3700");
            // props.setProperty("java.naming.factory.state",
            // "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            //           
            InitialContext ctx = new InitialContext(props);
            return ctx.lookup(jndipath);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}