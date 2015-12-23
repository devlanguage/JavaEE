<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.*,javax.servlet.jsp.*"%>
test1.jsp
<%@page import="javax.servlet.jsp.el.VariableResolver"%>
<%@page import="javax.servlet.jsp.el.ExpressionEvaluator"%>
<hr style="height: 12; color: red; border-color: red" />
d
<hr />
<pre>
pageContext=<%=pageContext%>

<jsp:useBean id="jsptest_UserBean" class="jsptest.UserBean"
		type="java.lang.Object">
	<jsp:setProperty name="jsptest_UserBean" property="userId"
			value="000111" />
	<jsp:setProperty name="jsptest_UserBean" property="userName"
			value="jsptest_UserBean.userName" />
</jsp:useBean>

<jsp:getProperty name="jsptest_UserBean" property="userName" />
<hr />
<%
  out.write("<font style='color: red; font-style: italic'>Internal Variable: request</font><br>");
        //request.getRequestDispatcher("test2.jsp").forward(request, response);
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
        for(int i=cookies.length-1; i>=0;--i){
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

        out.write("<font style='color: red; font-style: italic'>Internal Variable: pageContext</font><br>");
        pageContext.getAttributeNamesInScope(PageContext.SESSION_SCOPE);
        //pageContext.include("asdf");
        //pageContext.forward("asdf");
        //out.println("  pageContext.getErrorData()=" + pageContext.getErrorData());
        out.println("  pageContext.getException()=" + pageContext.getException());
        VariableResolver varResolver = pageContext.getVariableResolver();
        ExpressionEvaluator expEvaluator = pageContext.getExpressionEvaluator();
        out.println("  pageContext.getExpressionEvaluator()=" + expEvaluator);
        out.println("  pageContext.getVariableResolver()=" + varResolver);
        //JspWriter pageOut = pageContext.getOut();
        out.println("  pageContext.getOut()=" + pageContext.getOut());
        out.println("  pageContext.getRequest()=" + pageContext.getRequest());
        out.println("  pageContext.getResponse()=" + pageContext.getResponse());
        out.println("  pageContext.getSession()=" + pageContext.getSession());
        out.println("  pageContext.getServletConfig()=" + pageContext.getServletConfig());
        out.println("  pageContext.getServletContext()=" + pageContext.getServletContext());


        out.write("<font style='color: red; font-style: italic'>Internal Variable: session</font><br>");
        out.println("  session.getCreationTime()=" + session.getCreationTime());
        out.println("  session.getId()=" + session.getId());
        out.println("  session.getLastAccessedTime()=" + session.getLastAccessedTime());
        out.println("  session.getMaxInactiveInterval()=" + session.getMaxInactiveInterval());
        out.println("  session.getServletContext()=" + session.getServletContext());


        //response.sendRedirect("test2");
        config.getInitParameterNames();

        //application.getServerInfo();
        //application.getServlet("servletName");
        //application.getRealPath("page");
        //application.getResource("asdf");
        
  
        out.println("<hr>");
        Context ctx = new InitialContext();
        out.println(ctx.lookup("res/f"));
%>
</pre>

