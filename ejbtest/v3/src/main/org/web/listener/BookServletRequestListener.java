/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.book.ui.listener.BookServletRequestListener.java is created on 2008-6-13
 */
package org.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 
 */
public class BookServletRequestListener implements ServletRequestListener,
        ServletRequestAttributeListener, ServletContextListener {

    // From javax.servlet.ServletContextListener
    public void requestDestroyed(ServletRequestEvent servletrequestevent) {

        System.out.println("requestDestroyed");
        System.out.println(servletrequestevent);
    }

    public void requestInitialized(ServletRequestEvent servletrequestevent) {

        System.out.println("requestDestroyed");
        System.out.println(servletrequestevent);
    }

    // javax.servlet.ServletRequestAttributeListener
    public void attributeAdded(ServletRequestAttributeEvent servletrequestattributeevent) {

        System.out.println("attributeAdded");
        System.out.println(servletrequestattributeevent);
    }

    public void attributeRemoved(ServletRequestAttributeEvent servletrequestattributeevent) {

        System.out.println("attributeRemoved");
        System.out.println(servletrequestattributeevent);
    }

    public void attributeReplaced(ServletRequestAttributeEvent servletrequestattributeevent) {

        System.out.println("attributeReplaced");
        System.out.println(servletrequestattributeevent);
    }

    // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent servletcontextevent) {

        System.out.println("contextInitialized");
        System.out.println(servletcontextevent);
    }

    public void contextInitialized(ServletContextEvent servletcontextevent) {

        System.out.println("contextInitialized");
        System.out.println(servletcontextevent);
    }

}
