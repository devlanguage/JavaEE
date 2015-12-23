<%@page import="java.util.*,javax.servlet.jsp.*"%>
test1.jsp
<%@page import="javax.servlet.jsp.el.VariableResolver"%>
<%@page import="javax.servlet.jsp.el.ExpressionEvaluator"%>
<hr style="height: 12; color: red; border-color: red" />
<pre>
<hr>
<%
            out.write("<font style='color: red; font-style: italic'>Internal Variable: request=" + request + "</font><br>");
            out.write("request.getRequestDispatcher(\"test2.jsp\").forward(request, response)");
            out.println("  request.getCharacterEncoding()=" + request.getCharacterEncoding());
            out.println("  request.getContentLength()=" + request.getContentLength());
            out.println("  request.getContentType()=" + request.getContentType());
            out.println("  request.getContextPath()=" + request.getContextPath());
            out.println("  request.getCookies()=" + request.getCookies());
            out.println("  request.getSession()=" + request.getSession());
            out.println("  request.getRemoteAddr()=" + request.getRemoteAddr());
            out.println("  request.getRemoteHost()=" + request.getRemoteHost());
            out.println("  request.getRemotePort()=" + request.getRemotePort());
            out.println("  request.getRemoteUser()=" + request.getRemoteUser());
            out.println("  request.getQueryString()=" + request.getQueryString());
            Cookie[] cookies = request.getCookies();
            out.write("  <font style='color: blue; font-style: italic'>Request Cookie List</font><br>");
            for (int i = cookies.length - 1; i >= 0; --i) {
                out.println("     cookies[i].getComment()=" + cookies[i].getComment());
                out.println("     cookies[i].getDomain()=" + cookies[i].getDomain());
                out.println("     cookies[i].getMaxAge()=" + cookies[i].getMaxAge());
                out.println("     cookies[i].getName()=" + cookies[i].getName());
                out.println("     cookies[i].getPath()=" + cookies[i].getPath());
                out.println("     cookies[i].getValue()=" + cookies[i].getValue());
                out.println("     cookies[i].getVersion()=" + cookies[i].getVersion());
                out.println("     cookies[i].getSecure()=" + cookies[i].getSecure());
            }
            Enumeration reqAttrNames = request.getAttributeNames();
            out.write("  <font style='color: blue; font-style: italic'>Request Attributes List</font><br>");
            while (reqAttrNames.hasMoreElements()) {
                String attrName = (String) reqAttrNames.nextElement();
                out.println("     " + attrName + "=" + request.getAttribute(attrName));
            }
            out.write("  <font style='color: blue; font-style: italic'>Request Parameters List</font><br>");
            Enumeration params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String paramName = (String) params.nextElement();
                out.println("    " + paramName + "=" + request.getParameter(paramName));
            }
            
            
            out.write("<font style='color: red; font-style: italic'>Internal Variable: response=" + response + "</font><br>");
            out.println("  response.encodeRedirectURL(\"urlName\")=" + response.encodeRedirectURL("urlName"));          
            out.println("  response.encodeURL(\"urlName\")=" + response.encodeURL("urlName"));
            out.println("  response.getBufferSize()=" + response.getBufferSize());
            out.println("  response.getCharacterEncoding()=" + response.getCharacterEncoding());
            out.println("  response.getContentType()=" + response.getContentType());
            out.println("  response.getLocale()=" + response.getLocale());
            out.println("  response.getOutputStream()=" + response.getOutputStream());
            out.println("  response.getWriter()=" + response.getWriter());
            out.println("  response.addCookie(Coookie)");
            out.println("  response.addDateHeader(String, long)");
            out.println("  response.addHeader(String, String)");
            out.println("  response.addIntHeader(String,int)");
            out.println("  response.setError(int)");
            out.println("  response.setError(int,String)");
            out.println("  response.sendRedirect(filePath)");
            out.println("  response.setBufferSize(int)");

            out.write("<font style='color: red; font-style: italic'>Internal Variable: pageContext=" + pageContext + "</font><br>");
            out.println("  pageContext.include(\"filePath\");");
            out.println("  pageContext.include(\"filePath\", boolean);");
            out.println("  pageContext.forward(\"filePath\")");
            //out.println("  pageContext.getErrorData()=" + pageContext.getErrorData());
            out.println("  pageContext.getException()=" + pageContext.getException());
            VariableResolver varResolver = pageContext.getVariableResolver();
            ExpressionEvaluator expEvaluator = pageContext.getExpressionEvaluator();
            out.println("  pageContext.getExpressionEvaluator()=" + expEvaluator);
            out.println("  pageContext.getVariableResolver()=" + varResolver);
            //JspWriter pageOut = pageContext.getOut();
            out.println("  Enumeration allAttrNames = pageContext.getAttributeNamesInScope(PageContext.SESSION_SCOPE);");
            out.println("  pageContext.getOut()=" + pageContext.getOut());
            out.println("  pageContext.getRequest()=" + pageContext.getRequest());
            out.println("  pageContext.getResponse()=" + pageContext.getResponse());
            out.println("  pageContext.getSession()=" + pageContext.getSession());
            out.println("  pageContext.getServletConfig()=" + pageContext.getServletConfig());
            out.println("  pageContext.getServletContext()=" + pageContext.getServletContext());

            out.write("<font style='color: red; font-style: italic'>Internal Variable: session=" + session + "</font><br>");
            out.println("  session.getCreationTime()=" + session.getCreationTime());
            out.println("  session.getId()=" + session.getId());
            out.println("  session.getLastAccessedTime()=" + session.getLastAccessedTime());
            out.println("  session.getMaxInactiveInterval()=" + session.getMaxInactiveInterval());
            out.println("  session.getServletContext()=" + session.getServletContext());

            out.write("<font style='color: red; font-style: italic'>Internal Variable: config=" + config + "</font><br>");
            //response.sendRedirect("test2");
            out.println("  session.getServletName()=" + config.getServletName());
            out.println("  session.getServletContext()=" + config.getServletContext());
            out.write("  <font style='color: blue; font-style: italic'>config (ServletConfig) Init Parameters List</font><br>");
            Enumeration servletInitParams = config.getInitParameterNames();
            while (servletInitParams.hasMoreElements()) {
                String paramName = (String) servletInitParams.nextElement();
                out.println("    " + paramName + "=" + config.getInitParameter(paramName));
            }

            out.write("<font style='color: red; font-style: italic'>Internal Variable: application=" + application + "</font><br>");
            out.println("  application.getContextPath()=" + application.getContextPath());
            out.println("  application.getMajorVersion()=" + application.getMajorVersion());
            out.println("  application.getMimeType(filePath)" );            
            out.println("  application.getMinorVersion()=" + application.getMinorVersion());
            out.println("  application.getRealPath(\"C:/boot.ini\")="+  application.getRealPath("C:/boot.ini") );
            out.println("  application.getRealPath(\"WEB-INF/classes/log4j.properties\")="+ application.getRealPath("WEB-INF/classes/log4j.properties"));
            out.println("  application.getServerInfo()=" + application.getServerInfo());
            out.println("  application.getServletContextName()=" + application.getServletContextName());
            out.println("  application.getContext(\"ctxName\")");
%>
</pre>

