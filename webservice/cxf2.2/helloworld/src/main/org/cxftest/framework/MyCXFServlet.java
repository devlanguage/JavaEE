package org.cxftest.framework;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.transport.DestinationFactory;
import org.springframework.context.ApplicationEvent;

public class MyCXFServlet extends org.apache.cxf.transport.servlet.CXFServlet {

    private static final long serialVersionUID = 3581423174744474772L;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected DestinationFactory createServletTransportFactory() {
        return super.createServletTransportFactory();
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        super.onApplicationEvent(event);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

}
