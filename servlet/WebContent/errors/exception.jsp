
<%@page import="java.io.IOException"%><%@ page isErrorPage="true"
	errorPage="/errors/exception.jsp"%>
<%!public final static void printStackTrace(JspWriter out, StackTraceElement[] trcs) throws IOException {
        for (StackTraceElement trc : trcs) {
            out.print(" at " + trc + "<br>");
        }
    }%>

<%
printStackTrace(out, Thread.currentThread().getStackTrace());
printStackTrace(out, exception.getStackTrace());
%>
