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
			out.println("<BR>��ע��۲�Jboss����̨���.�ȴ�10����,��������ۻ��˻ỰBean,@PrePassivateע�͵ķ�������ִ��<BR>");			
			
			out.println("<font color=red>�����ִ�лỰBean��stopSession����,�ѻỰBeanʵ���Ӷ���������ߡ�����������ỰBean֮ǰ����ִ�� @PreDestroyע�͵ķ���<BR></font>");	
			/*
			lifecycle.stopSession();
			*/
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>
