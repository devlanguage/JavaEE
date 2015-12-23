<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.TimerService, javax.naming.*, java.util.Properties"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		try {
			InitialContext ctx = new InitialContext(props);
			TimerService timer = (TimerService) ctx.lookup("TimerServiceBean/remote");
			timer.scheduleTimer((long)3000);
			out.println("定时器已经启动，请观察Jboss控制台输出，如果定时器触发5次，便终止定时器");
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>