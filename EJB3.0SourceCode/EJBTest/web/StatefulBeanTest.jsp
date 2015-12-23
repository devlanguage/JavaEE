<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.MyAccount,javax.naming.*, java.util.Properties"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");	

		InitialContext ctx = new InitialContext(props);
		try {			
			MyAccount A = (MyAccount) ctx.lookup("MyAccountBean/remote");
			out.println("调用A.Add()的结果是："+ A.Add(1,1));
			out.println("<br>调用A.getResult()的结果："+ A.getResult());
			out.println("<br>========================================");
			MyAccount B = (MyAccount) ctx.lookup("MyAccountBean/remote");
			out.println("<br>调用B.Add()的结果是："+ B.Add(1,1));
			out.println("<br>调用B.getResult()的结果："+ B.getResult());
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>
