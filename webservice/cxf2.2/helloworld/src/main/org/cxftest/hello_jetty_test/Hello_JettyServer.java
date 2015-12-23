package org.cxftest.hello_jetty_test;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.handler.DefaultHandler;
import org.mortbay.jetty.handler.HandlerCollection;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

public class Hello_JettyServer {

    public final static int JETTY_SERVER_PORT = 9090;

    protected Hello_JettyServer() throws Exception {
        System.out.println("Starting Server");

        org.mortbay.jetty.Server server = new org.mortbay.jetty.Server();

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(JETTY_SERVER_PORT);
        server.setConnectors(new Connector[] { connector });

        WebAppContext webappcontext = new WebAppContext();
        webappcontext.setContextPath("/");
        webappcontext.setWar("D:/Java/eclipse_projects/webservice/source/cxf2.2/helloworld/src/main/webapp");
        // webappcontext.setWar("WebRoot");

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { webappcontext, new DefaultHandler() });

        server.setHandler(handlers);
        server.start();
        System.out.println("Server ready...");
        server.join();
    }

    public static void main(String args[]) throws Exception {
        new Hello_JettyServer();
    }
}
