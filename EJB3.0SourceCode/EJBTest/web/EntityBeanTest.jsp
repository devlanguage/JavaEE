<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.PersonDAO,com.foshanshop.ejb3.bean.Person,
				javax.naming.*, 
				java.util.Properties, 
				java.util.Date,
				java.util.List,
				java.text.SimpleDateFormat"%>

<TABLE width="80%" border="1">
<TR bgcolor="#DFDFDF">
	<TD>personid</TD>
	<TD>name</TD>
	<TD>sex</TD>
	<TD>age</TD>
	<TD>birthday</TD>
</TR>
<%
try {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	
		InitialContext ctx = new InitialContext(props);
	    PersonDAO persondao = (PersonDAO) ctx.lookup("PersonDAOBean/remote");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");			
		persondao.insertPerson("黎明", true, (short)26,formatter.parse("1980-9-30"));//添加一个人
		
		List list = persondao.getPersonList();
	    for(int i=0; i<list.size(); i++){
            Person person = (Person)list.get(i);
			out.println("<TR><TD>"+ person.getPersonid()+"</TD><TD>"+ person.getName()+"</TD><TD>"+ person.getSex()+"</TD><TD>"+ person.getAge()+"</TD><TD>"+ person.getBirthday()+"</TD></TR>");
        }

} catch (Exception e) {
	out.println(e.getMessage());
}
%>
</TABLE>