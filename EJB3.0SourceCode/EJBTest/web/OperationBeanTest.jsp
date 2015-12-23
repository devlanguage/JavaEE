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
			out.println("ͨ��Զ�̽ӿڵ���EJB�ɹ�");
			out.println("<br>(ͨ��Զ�̽ӿڵ���EJB)��ӵĽ���ǣ�"+ operation.Add(1,1));
		} catch (Exception e) {
			out.println("<br>Զ�̽ӿڵ���ʧ��");
		}
		out.println("<br>==============================================");
		try {
			//ͨ�����ؽӿڵ���EJB
			LocalOperation A = (LocalOperation) ctx.lookup("OperationBean/local");
			out.println("<br>(ͨ�����ؽӿڵ���EJB)����A.Add()�Ľ���ǣ�"+ A.Add(1,1));
			out.println("<br>����A.getResult()�Ľ���ǣ�"+ A.getResult());

			LocalOperation B = (LocalOperation) ctx.lookup("OperationBean/local");
			out.println("<br>(ͨ�����ؽӿڵ���EJB)����B.Add()�Ľ���ǣ�"+ B.Add(1,1));
			out.println("<br>����B.getResult()�Ľ���ǣ�<font color=red>"+ B.getResult() + "</font>");
		} catch (Exception e) {
			out.println("<br>���ؽӿڵ���ʧ��");
		}
%>
