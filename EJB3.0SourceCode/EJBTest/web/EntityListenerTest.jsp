<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.EntityLifecycleDAO,com.foshanshop.ejb3.EntityLifecycle,
				javax.naming.*, 
				java.util.Properties"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		InitialContext ctx = new InitialContext(props);
		try {
			out.println("输出信息将打印在Jboss控制台,每个方法的执行都会停留5秒");
			out.println(",以便你更好地观察生命周期回调方法的运行效果");

		    EntityLifecycleDAO entitylifecycledao = (EntityLifecycleDAO) ctx.lookup("EntityLifecycleDAOBean/remote");	
			entitylifecycledao.Persist(); //添加测试数据
			entitylifecycledao.Load(); //载入数据 
			entitylifecycledao.Update(); //更新数据 
			
			entitylifecycledao.Remove(); //删除最后一条数据
			
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>