<%@page contentType="text/html; charset=UTF-8" isErrorPage="true"%>

<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.net.UnknownHostException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>eCustoms - Error</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ecustoms.css" type="text/css"
	media="all" />
</head>
<body>
<%StackTraceElement[] traces= exception.getStackTrace();
for(StackTraceElement trace:traces){    
 out.println(trace.toString());out.println("<BR>");
}
%>
<div class="header1">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td class="tabTopL">Server Error</td>
		<td class="tabTopR">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>

<div class="header2">Encounter Error</div>
<table class="sectionBorder">
	<tr>
		<td class="sectionTitle">Use Guide</td>
	</tr>
	<tr>
		<td class="txtData">An unexpected server error has been
		encountered. Please report the following information to help desk:<br>
		Server error on [ <%=new Date()%> ] at server [ <%=pageContext.getServletContext().getServerInfo()%>
		]."</td>
	</tr>
</table>

<div class="header2">Error Message</div>
<img src="<%=request.getContextPath()%>/images/alert.gif" title="Alert"
	alt="Alert" width="17" height="15" />
<span class="txtData"> <%
     String errMsg = null;
     if (exception != null) {
         if (exception instanceof javax.faces.FacesException) {
             exception = ((javax.faces.FacesException) exception).getCause();
             if (exception instanceof javax.faces.el.EvaluationException) {
                 Throwable t = ((javax.faces.el.EvaluationException) exception).getCause();
                 if (t instanceof Exception) {
                     exception = (Exception) t;
                 }
             }
         }
         //Note: For displaying the error messages, the following is just a temporary solution.
         //Handle customized exceptions first..
         if (exception instanceof java.lang.NullPointerException) {
             errMsg = exception.getMessage();
         } else {
             errMsg = exception.getMessage();
         }
     } else {
         errMsg = "System is busy, please try later.";
     }
     out.println(errMsg);
 %> </span>
<div class="gap5pix"></div>

<%
    if (exception != null) {
%>
<table class="sectionBorder">
	<tr>
		<td class="sectionTitle">Error Message Detail</td>
	</tr>
	<tr>
		<td class="txtData">
		<%
		    try {
		            out.write(exception.getMessage());
		        } catch (Exception ex) {
		            out.write("Unknown Message");
		        }
		%>
		</td>
	</tr>
</table>
<%
    }
%>
<br>
</body>
</html>

