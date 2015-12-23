package org.basic.servlet.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

public class WebXmlSessionListener implements javax.servlet.http.HttpSessionListener, javax.servlet.http.HttpSessionActivationListener,
        javax.servlet.http.HttpSessionAttributeListener, javax.servlet.http.HttpSessionBindingListener {

    // javax.servlet.http.HttpSessionListener
    public void sessionCreated(HttpSessionEvent httpsessionevent) {

        System.out.println(this.getClass().getSimpleName() + ".sessionCreated");
    }

    public void sessionDestroyed(HttpSessionEvent httpsessionevent) {

        System.out.println(this.getClass().getSimpleName() + ".sessionDestroyed");
    }

    // javax.servlet.http.HttpSessionActivationListener
    public void sessionDidActivate(HttpSessionEvent httpsessionevent) {

        System.out.println(this.getClass().getSimpleName() + ".sessionDidActivate");
    }

    public void sessionWillPassivate(HttpSessionEvent httpsessionevent) {

        System.out.println(this.getClass().getSimpleName() + ".sessionWillPassivate");
    }

    // javax.servlet.http.HttpSessionAttributeListener
    public void attributeAdded(HttpSessionBindingEvent httpsessionbindingevent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeAdded");
    }

    public void attributeRemoved(HttpSessionBindingEvent httpsessionbindingevent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeRemoved");
    }

    public void attributeReplaced(HttpSessionBindingEvent httpsessionbindingevent) {

        System.out.println(this.getClass().getSimpleName() + ".attributeReplaced");
    }

    // javax.servlet.http.HttpSessionBindingListener
    public void valueBound(HttpSessionBindingEvent httpsessionbindingevent) {

        System.out.println(this.getClass().getSimpleName() + ".valueBound");
    }

    public void valueUnbound(HttpSessionBindingEvent httpsessionbindingevent) {

        System.out.println(this.getClass().getSimpleName() + ".valueUnbound");
    }
}
