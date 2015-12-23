<%@page import="java.util.Enumeration"%>
hi, this welcome page
<%Enumeration attrEnum = request.getAttributeNames();
            while (attrEnum.hasMoreElements()) {
                String attrName = (String) attrEnum.nextElement();
                out.println(attrName + "=" + request.getAttribute(attrName) + "<br>");
            }%>
            
<%@page import="javax.naming.InitialContext"%>
<%@page import="org.ejbtest.account.service.AccountServiceLocal"%>
<br>
jndi test
<br>
<%
	javax.naming.Context ctx = new InitialContext();
	javax.sql.DataSource oracleDS = (javax.sql.DataSource) ctx.lookup("java:/OracleDS");
	AccountServiceLocal accountServiceLocal= (AccountServiceLocal)ctx.lookup("AccountService/local");
%>
oracleDS=<%=oracleDS%><br>
accountServiceLocal=<%=accountServiceLocal%><br>
asdfsd