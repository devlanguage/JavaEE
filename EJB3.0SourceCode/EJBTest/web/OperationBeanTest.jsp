<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.Operation,com.foshanshop.ejb3.LocalOperation, javax.naming.*, java.util.Properties"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		InitialContext ctx = new InitialContext(props);
		try {			
			Operation operation = (Operation) ctx.lookup("OperationBean/remote");
			out.println("通过远程接口调用EJB成功");
			out.println("<br>(通过远程接口调用EJB)相加的结果是："+ operation.Add(1,1));
		} catch (Exception e) {
			out.println("<br>远程接口调用失败");
		}
		out.println("<br>==============================================");
		try {
			//通过本地接口调用EJB
			LocalOperation A = (LocalOperation) ctx.lookup("OperationBean/local");
			out.println("<br>(通过本地接口调用EJB)调用A.Add()的结果是："+ A.Add(1,1));
			out.println("<br>调用A.getResult()的结果是："+ A.getResult());

			LocalOperation B = (LocalOperation) ctx.lookup("OperationBean/local");
			out.println("<br>(通过本地接口调用EJB)调用B.Add()的结果是："+ B.Add(1,1));
			out.println("<br>调用B.getResult()的结果是：<font color=red>"+ B.getResult() + "</font>");
		} catch (Exception e) {
			out.println("<br>本地接口调用失败");
		}
%>
