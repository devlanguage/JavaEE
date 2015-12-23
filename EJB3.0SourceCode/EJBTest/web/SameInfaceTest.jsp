<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.Same, javax.naming.*, java.util.Properties"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			Same same = (Same) ctx.lookup("SameBean/remote");
			out.println(same.say("·ðÉ½ÈË"));
			out.println("<br>----------------------------------<br>");
			Same same2 = (Same) ctx.lookup("SameBean/local");
			out.println(same2.say("ÀèÃ÷"));
		} catch (NamingException e) {
			out.println(e.getMessage());
		}
%>
