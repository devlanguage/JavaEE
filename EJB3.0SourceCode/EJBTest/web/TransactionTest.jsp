<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.TransactionDAO,
				javax.naming.*,
				java.util.*"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		try {
			InitialContext ctx = new InitialContext(props);
			TransactionDAO transactiondao = (TransactionDAO) ctx.lookup("TransactionDAOBean/remote");
			transactiondao.insertProduct("电脑", new Float("1200"), false);
			transactiondao.ModifyProductName("数码相机", true);
			out.println("执行完成");
		} catch (Exception e) {
			out.println(e.getMessage());			
		}
%>