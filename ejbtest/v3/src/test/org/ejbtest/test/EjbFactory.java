/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.test.account.service.EjbFactory.java is created on 2008-7-1
 */
package org.ejbtest.test;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 
 */
public class EjbFactory {

    public static Object getEJB(String jndipath) {

        try {
            Properties props = new Properties();

            // java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory
            // java.naming.factory.url.pkgs=org.jboss.naming:org.jnp.interfaces
            
            props.setProperty("java.naming.factory.initial",
                    "org.jnp.interfaces.NamingContextFactory");
//            props.setProperty("java.naming.provider.url",
//                    "192.168.0.149:1099,192.168.0.60,192.168.0.51:1099");
            props.setProperty("java.naming.provider.url","localhost:1099");
            props.setProperty("java.naming.factory.url.pkgs",
                            "org.jboss.naming:org.jnp.interfaces");
//            props.setProperty("jnp.disableDiscovery", "true");
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