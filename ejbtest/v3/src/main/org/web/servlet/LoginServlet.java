/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.servlet.ui.servlet.LoginServlet.java is created on 2008-7-8
 */
package org.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@SuppressWarnings(value = { "serial" })
public class LoginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        java.util.Enumeration initParamEnum = config.getInitParameterNames();
        while (initParamEnum.hasMoreElements()) {
            String paramName = (String) initParamEnum.nextElement();
            System.out.println(paramName + "=" + config.getInitParameter(paramName));
        }
        System.out.println("servletName=" + config.getServletName());
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        
        System.out.println(req);
        System.out.println(resp);
        PrintWriter out = resp.getWriter();
        out.print("current pagen");
        // if forward, "curret page" content will be ignored
        // if include, "curret page" content will be kept, 被包含的Servlet不能修改任何response status code 或者
        // response header

        req.setAttribute("req.getAuthType()", req.getAuthType());
        req.setAttribute("req.getCharacterEncoding()", req.getCharacterEncoding());
        req.setAttribute("req.getContentType()", req.getContentType());
        req.setAttribute("req.getContextPath()", req.getContextPath());
        req.setAttribute("req.getLocalAddr()", req.getLocalAddr());
        req.setAttribute("req.getMethod()", req.getMethod());
        req.setAttribute("req.getPathTranslated()", req.getPathTranslated());
        req.setAttribute("req.getProtocol()", req.getProtocol());
        req.setAttribute("req.getQueryString()", req.getQueryString());
        req.setAttribute("req.getRealPath()", req.getRealPath("realpath"));
        req.setAttribute("req.getRemoteAddr()", req.getRemoteAddr());
        req.setAttribute("req.getRemoteHost()", req.getRemoteHost());
        req.setAttribute("req.getRemotePort()", req.getRemotePort());
        req.setAttribute("req.getRemoteUser()", req.getRemoteUser());
        req.setAttribute("req.getRequestURI()", req.getRequestURI());
        req.setAttribute("req.getPathInfo()", req.getPathInfo());
        System.out.println("");

        RequestDispatcher welcomeDispatcher = req.getRequestDispatcher("/jsps/welcome.jsp");
        // Includes the content of a resource (servlet, JSP page, HTML file) in the response.
        // The included servlet cannot change the response status code or set headers; any attempt
        // to make a change is ignored
        welcomeDispatcher.forward(req, resp);
    }
}
