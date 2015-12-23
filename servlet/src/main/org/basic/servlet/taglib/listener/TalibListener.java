package org.basic.servlet.taglib.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class TalibListener implements ServletContextListener, ServletRequestListener, ServletRequestAttributeListener {

    // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent servletcontextevent) {

        System.out.println(this.getClass().getSimpleName() + ".contextDestroyed");
    }

    public void contextInitialized(ServletContextEvent servletcontextevent) {

        System.out.println(this.getClass().getSimpleName() + ".contextInitialized");
    }

    // From javax.servlet.ServletRequestListener
    public void requestDestroyed(ServletRequestEvent servletrequestevent) {

        System.out.println(this.getClass().getSimpleName() + ".requestDestroyed");
    }

    public void requestInitialized(ServletRequestEvent servletrequestevent) {

        System.out.println(this.getClass().getSimpleName() + ".requestInitialized");
    }

    // javax.servlet.ServletRequestAttributeListener
    public void attributeAdded(ServletRequestAttributeEvent servletrequestattributeevent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeAdded");
    }

    public void attributeRemoved(ServletRequestAttributeEvent servletrequestattributeevent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeRemoved");
    }

    public void attributeReplaced(ServletRequestAttributeEvent servletrequestattributeevent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeReplaced");
    }

}