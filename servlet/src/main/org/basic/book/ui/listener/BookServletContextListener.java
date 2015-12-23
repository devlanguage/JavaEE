/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.book.ui.listener.BookSessionListener.java is created on 2008-6-13
 */
package org.basic.book.ui.listener;

import javax.servlet.ServletContextEvent;

/**
 * 
 */
public class BookServletContextListener implements javax.servlet.ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {

        System.out.println("Servlet Context Initialized");
        System.out.println(contextEvent);
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {

        System.out.println("Servlet Context destroyed");
        System.out.println(contextEvent);
    }

}
