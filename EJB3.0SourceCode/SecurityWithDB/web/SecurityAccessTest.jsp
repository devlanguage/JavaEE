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
				out.println("<font color=green>调用结果:</font>"+ securityaccess.AdminUserMethod()+ "<br>");
			}catch(Exception e){
				out.println(user+ "没有权限访问AdminUserMethod方法<BR>");
			}

			out.println("==========================<BR>");
			try{
				out.println("<font color=green>调用结果:</font>"+ securityaccess.DepartmentUserMethod()+ "<br>");
			}catch(Exception e){
				out.println(user+ "没有权限访问DepartmentUserMethod方法<BR>");
			}

			out.println("==========================<BR>");
			try{
				out.println("<font color=green>调用结果:</font>"+ securityaccess.AnonymousUserMethod()+ "<br>");
			}catch(Exception e){
				out.println(user+ "没有权限访问AnonymousUserMethod方法<BR>");
			}
			
			SecurityAssociation.clear();		
%>

<html>
  <head>
    <title>安全访问测试</title>
  </head>

  <body>
    <center><h2>安全访问测试</h2></center>
    <br />
    请输入你的用户名及密码
    <br />
    <form method="POST" action="SecurityAccessTest.jsp">
       Username: <input type="text" name="user"/>
       <br />
       Password: <input type="password" name="pwd"/>
       <br />
       <input type="submit" value="身份验证"/>
    </form>
    <p>
      管理员  用户名: <STRONG>lihuoming</STRONG>&nbsp;&nbsp;密码: <STRONG>123456</STRONG>
    </p>
    <p>事业部  用户名: <STRONG>zhangfeng</STRONG>&nbsp;&nbsp;密码 <STRONG>111111</STRONG></p>
	<p>合作伙伴  用户名: <STRONG>wuxiao</STRONG>&nbsp;&nbsp;密码 <STRONG>123</STRONG></p>
  </body>
</html>