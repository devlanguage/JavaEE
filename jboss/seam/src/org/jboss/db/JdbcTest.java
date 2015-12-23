package org.jboss.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcTest {
    enum ContainerType {
        JBOSS, GLASSFISH, WEBLOGIC
    }

    public final static InitialContext getContext(ContainerType container) throws NamingException {
        Properties props = new Properties();
        switch (container) {
            case JBOSS:
                // java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory
                // java.naming.factory.url.pkgs=org.jboss.naming:org.jnp.interfaces
                props.setProperty(InitialContext.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
                props.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
                props.setProperty(InitialContext.PROVIDER_URL, "jnp://localhost:1099"); // 访问远程 jboss 服务器
                break;
            case GLASSFISH:
                props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
                props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
                props.setProperty("java.naming.factory.state",
                        "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
                props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");// EJB容器的ip
                props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");// EJB容器端口,默认为：3700
                break;
            case WEBLOGIC:
                props.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory ");
                props.setProperty(InitialContext.PROVIDER_URL, "t3://localhost:7001 ");
                break;
            default:
                break;
        }

        InitialContext ic = new InitialContext(props);
        return ic;
    }

    public static void main(String[] args) {

        DataSource ds = null;
        Connection con = null;
        PreparedStatement pr = null;

        try {
            System.out.println(getContext(ContainerType.JBOSS).lookup("SecureProfileService/remote").getClass());
            System.out.println("====");
            System.out.println(getContext(ContainerType.JBOSS).lookup("queue/DLQ").getClass());
            System.out.println("====");
            System.out.println(getContext(ContainerType.JBOSS).lookup("ConnectionFactory").getClass());
            System.out.println("===="); 
            for (Enumeration enum1 = getContext(ContainerType.JBOSS).list("/"); enum1.hasMoreElements();) {
                System.out.println(enum1.nextElement());
            }
//            UserTransactionSessionFactory: $Proxy218
//            UUIDKeyGeneratorFactory: org.jboss.ejb.plugins.keygenerator.uuid.UUIDKeyGeneratorFactory
//            SecureManagementView: org.jnp.interfaces.NamingContext
//            SecureDeploymentManager: org.jnp.interfaces.NamingContext
//            HiLoKeyGeneratorFactory: org.jboss.ejb.plugins.keygenerator.hilo.HiLoKeyGeneratorFactory
//            XAConnectionFactory: org.jboss.jms.client.JBossConnectionFactory
//            topic: org.jnp.interfaces.NamingContext
//            ClusteredConnectionFactory: org.jboss.jms.client.JBossConnectionFactory
//            ProfileService: org.jboss.aop.generatedproxies.AOPProxy$2
//            SecureProfileService: org.jnp.interfaces.NamingContext
//            queue: org.jnp.interfaces.NamingContext
//            ClusteredXAConnectionFactory: org.jboss.jms.client.JBossConnectionFactory
//            UserTransaction: org.jboss.tm.usertx.client.ClientUserTransaction
//            ConnectionFactory: org.jboss.jms.client.JBossConnectionFactory
//            jmx: org.jnp.interfaces.NamingContext
//            TomcatAuthenticators: java.util.Properties
//            console: org.jnp.interfaces.NamingContext

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
    }
}
