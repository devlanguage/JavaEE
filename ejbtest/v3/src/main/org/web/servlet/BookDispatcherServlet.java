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
 * <filter-mapping>
 *     <filter-name>DispatcherFilterIcd</filter-name>
 *     <url-pattern>/admin</url-pattern>
 *     <dispatcher>INCLUDE</dispatcher>
 * </filter-mapping>
 * <filter-mapping>
 *      <filter-name>DispatcherFilterErr</filter-name>
 *      <url-pattern>/errorpage</url-pattern>
 *      <dispatcher>ERROR</dispatcher>
 * </filter-mapping>
 * 
 */
public class BookDispatcherServlet extends HttpServlet {

    String dispatchtype;

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        PrintWriter out = resp.getWriter();
        String type = "NONE";
        if ((req.getParameter("type")) != null) {
            type = req.getParameter("type");
        }
        resp.setContentType("text/html");
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<HR>");
        out.println("<p>");
        out.println("ReqDispacherServelt");
        out.println("</P><p>");
        out.println("ServerName:" + req.getServerName() + "ServerPort:" + req.getServerPort());
        out.println("</p>");
        RequestDispatcher rd = req.getRequestDispatcher("/admin");
        RequestDispatcher rd2 = req.getRequestDispatcher("/control");
        if (type.equals("REQUEST")) {
        }
        if (type.equals("FORWARD")) {
            rd.forward(req, resp);
        }
        if (type.equals("INCLUDE")) {
            rd.include(req, resp);
        }
        if (type.equals("ERROR")) {
            resp.sendError(404, "Error from ReqDispacherServlet");
        }
        if (type.equals("CONTROL")) {
            rd2.forward(req, resp);
        }
        out.flush();
    }  
}