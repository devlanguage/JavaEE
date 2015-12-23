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
			out.println("�����Ϣ����ӡ��Jboss����̨,ÿ��������ִ�ж���ͣ��5��");
			out.println(",�Ա�����õع۲��������ڻص�����������Ч��");

		    EntityLifecycleDAO entitylifecycledao = (EntityLifecycleDAO) ctx.lookup("EntityLifecycleDAOBean/remote");	
			entitylifecycledao.Persist(); //��Ӳ�������
			entitylifecycledao.Load(); //�������� 
			entitylifecycledao.Update(); //�������� 
			
			entitylifecycledao.Remove(); //ɾ�����һ������
			
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>