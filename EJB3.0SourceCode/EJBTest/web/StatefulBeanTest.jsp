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
			out.println("����A.Add()�Ľ���ǣ�"+ A.Add(1,1));
			out.println("<br>����A.getResult()�Ľ����"+ A.getResult());
			out.println("<br>========================================");
			MyAccount B = (MyAccount) ctx.lookup("MyAccountBean/remote");
			out.println("<br>����B.Add()�Ľ���ǣ�"+ B.Add(1,1));
			out.println("<br>����B.getResult()�Ľ����"+ B.getResult());
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>
