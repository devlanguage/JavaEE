<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.LifeCycle, javax.naming.*, java.util.Properties"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		try {
			LifeCycle lifecycle = (LifeCycle) session.getAttribute("lifecycle");
			if (lifecycle == null) {
			  InitialContext ctx = new InitialContext(props);
			  lifecycle = (LifeCycle) ctx.lookup("LifeCycleBean/remote");
			  session.setAttribute ("lifecycle", lifecycle);
			}
			out.println(lifecycle.Say());
			out.println("<BR>请注意观察Jboss控制台输出.等待10分钟,容器将会钝化此会话Bean,@PrePassivate注释的方法将会执行<BR>");			
			
			out.println("<font color=red>你可以执行会话Bean的stopSession方法,把会话Bean实例从对象池中移走。在销毁这个会话Bean之前将会执行 @PreDestroy注释的方法<BR></font>");	
			/*
			lifecycle.stopSession();
			*/
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>
