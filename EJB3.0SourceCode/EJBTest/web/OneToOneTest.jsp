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
			oneToonedao.insertPerson("�����", true, (short)26,formatter.parse("1980-9-30"), "44011"+endno);
			//���ʱ��ע�⣬���֤�Ų�Ҫ�ظ�����Ϊ���ݿ��ֶ����֤����Ψһ��
			Person person = oneToonedao.getPersonByID(new Integer(1)); 
			if (person!=null){
				out.println(outformate +"Ѱ�ұ��Ϊ1����Ա<br>");
				out.println("����:"+ person.getName() +" ���֤��"+ person.getIdcard().getCardno() +"<br>");
			}else{
				out.println("û���ҵ����Ϊ1����Ա<br>");
			}

			out.println(outformate +"���±��Ϊ1����Ա������Ϊ����,���֤��Ϊ33012" +endno +"<br>");
			oneToonedao.updatePersonInfo(new Integer(1), "����", "33012" +endno);			
			
			out.println("================ɾ�����Ϊ3����Ա==============<br>");	
			oneToonedao.deletePerson(new Integer(3));
			
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>