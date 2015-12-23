package org.basic.servlet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextEvent;

public class WebXmlContextListener implements javax.servlet.ServletContextListener, javax.servlet.ServletContextAttributeListener {

    // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent ctxEvent) {

        System.out.println(this.getClass().getSimpleName() + ".contextDestroyed");
    }

    public void contextInitialized(ServletContextEvent ctxEvent) {

        System.out.println("/*****\n Servlet " + ctxEvent.getServletContext().getServerInfo() + " restarted  \n ******/\n");
        System.out.println(this.getClass().getSimpleName() + ".contextInitialized");
    }

    // javax.servlet.ServletContextAttributeListener
    public void attributeAdded(ServletContextAttributeEvent ctxAttrEvent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeAdded");
    }

    public void attributeRemoved(ServletContextAttributeEvent ctxAttrEvent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeRemoved");
    }

    public void attributeReplaced(ServletContextAttributeEvent ctxAttrEvent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeReplaced");
    }
}
