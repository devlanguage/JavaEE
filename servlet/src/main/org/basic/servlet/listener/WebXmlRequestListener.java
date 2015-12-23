package org.basic.servlet.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestEvent;

public class WebXmlRequestListener implements javax.servlet.ServletRequestListener, javax.servlet.ServletRequestAttributeListener {


    // From javax.servlet.ServletRequestListener
    public void requestDestroyed(ServletRequestEvent reqEvent) {

        System.out.println(this.getClass().getSimpleName() + ".requestDestroyed");
    }

    public void requestInitialized(ServletRequestEvent servletrequestevent) {

        System.out.println(this.getClass().getSimpleName() + ".requestInitialized");
    }

    // javax.servlet.ServletRequestAttributeListener
    public void attributeAdded(ServletRequestAttributeEvent reqAttrEvent) {
        System.out.println(this.getClass().getSimpleName() + ".attributeAdded");
    }

    public void attributeRemoved(ServletRequestAttributeEvent reqAttrEvent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeRemoved");
    }

    public void attributeReplaced(ServletRequestAttributeEvent reqAttrEvent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeReplaced");
    }

}
