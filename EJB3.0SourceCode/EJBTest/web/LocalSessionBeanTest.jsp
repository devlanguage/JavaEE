<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.LocalHelloWorld, javax.naming.*, java.util.Properties"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			LocalHelloWorld helloworld = (LocalHelloWorld) ctx.lookup("LocalHelloWorldBean/local");
			out.println(helloworld.SayHello("·ðÉ½ÈË"));
		} catch (NamingException e) {
			out.println(e.getMessage());
		}
%>
