<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.SecurityAccess,
				javax.naming.*,
				org.jboss.security.*,
				java.util.*"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	
		InitialContext ctx = new InitialContext(props);	

		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if (user!=null && !"".equals(user.trim())){			
			SecurityAssociation.setPrincipal(new SimplePrincipal(user.trim()));
			SecurityAssociation.setCredential(pwd.trim().toCharArray());
		}
			SecurityAccess securityaccess = (SecurityAccess) ctx.lookup("SecurityAccessBean/remote");
			try{				
				out.println("<font color=green>���ý��:</font>"+ securityaccess.AdminUserMethod()+ "<br>");
			}catch(Exception e){
				out.println(user+ "û��Ȩ�޷���AdminUserMethod����<BR>");
			}

			out.println("==========================<BR>");
			try{
				out.println("<font color=green>���ý��:</font>"+ securityaccess.DepartmentUserMethod()+ "<br>");
			}catch(Exception e){
				out.println(user+ "û��Ȩ�޷���DepartmentUserMethod����<BR>");
			}

			out.println("==========================<BR>");
			try{
				out.println("<font color=green>���ý��:</font>"+ securityaccess.AnonymousUserMethod()+ "<br>");
			}catch(Exception e){
				out.println(user+ "û��Ȩ�޷���AnonymousUserMethod����<BR>");
			}
			
			SecurityAssociation.clear();		
%>

<html>
  <head>
    <title>��ȫ���ʲ���</title>
  </head>

  <body>
    <center><h2>��ȫ���ʲ���</h2></center>
    <br />
    ����������û���������
    <br />
    <form method="POST" action="SecurityAccessTest.jsp">
       Username: <input type="text" name="user"/>
       <br />
       Password: <input type="password" name="pwd"/>
       <br />
       <input type="submit" value="�����֤"/>
    </form>
    <p>
      ����Ա  �û���: <STRONG>lihuoming</STRONG>&nbsp;&nbsp;����: <STRONG>123456</STRONG>
    </p>
    <p>��ҵ��  �û���: <STRONG>zhangfeng</STRONG>&nbsp;&nbsp;���� <STRONG>111111</STRONG></p>
	<p>�������  �û���: <STRONG>wuxiao</STRONG>&nbsp;&nbsp;���� <STRONG>123</STRONG></p>
  </body>
</html>