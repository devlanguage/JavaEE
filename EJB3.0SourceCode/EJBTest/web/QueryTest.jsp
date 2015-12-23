<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.QueryDAO,
				javax.naming.*,
				java.util.Date,
				java.text.SimpleDateFormat,
				java.util.*"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	


		try {
			String index = request.getParameter("index");
			if (index!=null && !"".equals(index.trim())){
				InitialContext ctx = new InitialContext(props);
				QueryDAO querydao = (QueryDAO) ctx.lookup("QueryDAOBean/remote");
				querydao.initdate();
				out.println(querydao.ExecuteQuery(Integer.parseInt(index)));
			}
		} catch (Exception e) {
			out.println(e.getMessage());			
		}
%>