/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.book.ui.listener.BookServletRequestListener.java is created on 2008-6-13
 */
package org.basic.book.ui.listener;

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
    public void requestDestroyed(ServletRequestEvent servletrequestevent) {}
    public void requestInitialized(ServletRequestEvent servletrequestevent) {}

    // javax.servlet.ServletRequestAttributeListener
    public void attributeAdded(ServletRequestAttributeEvent servletrequestattributeevent) { }
    public void attributeRemoved(ServletRequestAttributeEvent servletrequestattributeevent) { }
    public void attributeReplaced(ServletRequestAttributeEvent servletrequestattributeevent) {  }
    
    // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent servletcontextevent) {  }
    public void contextInitialized(ServletContextEvent servletcontextevent) { }

}
