<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.OneToOneDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*,
				java.util.Date,
				java.text.SimpleDateFormat,
				java.util.*"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		InitialContext ctx = new InitialContext(props);
		try {
			String outformate = "<font color=blue>CMD>>Out>></font> ";
			OneToOneDAO oneToonedao = (OneToOneDAO) ctx.lookup("OneToOneDAOBean/remote");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatter1 = new SimpleDateFormat("MMddhhmmss");
			String endno = formatter1.format(new Date()).toString();
			oneToonedao.insertPerson("黎活明", true, (short)26,formatter.parse("1980-9-30"), "44011"+endno);
			//添加时请注意，身份证号不要重复，因为数据库字段身份证号是唯一的
			Person person = oneToonedao.getPersonByID(new Integer(1)); 
			if (person!=null){
				out.println(outformate +"寻找编号为1的人员<br>");
				out.println("姓名:"+ person.getName() +" 身份证："+ person.getIdcard().getCardno() +"<br>");
			}else{
				out.println("没有找到编号为1的人员<br>");
			}

			out.println(outformate +"更新编号为1的人员的姓名为李明,身份证号为33012" +endno +"<br>");
			oneToonedao.updatePersonInfo(new Integer(1), "李明", "33012" +endno);			
			
			out.println("================删除编号为3的人员==============<br>");	
			oneToonedao.deletePerson(new Integer(3));
			
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>