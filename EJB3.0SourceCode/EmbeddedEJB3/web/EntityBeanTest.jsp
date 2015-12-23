<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.PersonDAO, 
				com.foshanshop.ejb3.bean.Person,
				javax.naming.*, 
				com.foshanshop.conf.Constants,
				java.util.Properties, 
				java.util.Date,
				java.util.List,
				java.util.Iterator,
				java.text.SimpleDateFormat"%>
<%
		try {		
		    InitialContext ctx = Constants.getInitialContext();

		    PersonDAO persondao = (PersonDAO) ctx.lookup("PersonDAOBean/remote");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");			
			persondao.insertPerson("�����", true, (short)26,formatter.parse("1980-9-30"));//���һ����
			out.println(persondao.getPersonNameByID(1)); //ȡpersonidΪ1��������

			Person person = persondao.getPersonByID(1); //ȡpersonidΪ1��person,��ʱ��person�Ѿ����������Ĺ���
			person.setName("��С��"); //��������Ϊ��С��
			persondao.updatePerson(person); //����person 
			out.println("<br> personidΪ1��person���������������Ϊ ��С��");

			out.println("<br>============  ��ҳ��ʾ,ÿҳ��¼��Ϊ2 =========<BR>");

			String index = request.getParameter("index");
			if (index==null || "".equals(index.trim())) index = "1";

			int max = 2; //ÿҳ��¼��Ϊ2
			int whichpage = Integer.parseInt(index); //�ڼ�ҳ
			List list = persondao.getPersonList(max, whichpage);
			if (list!=null){
				Iterator it = list.iterator();
				while (it.hasNext()) {
				  Person p = (Person)it.next();
				  out.println("��Ա���:"+ p.getPersonid() + " ������"+ p.getName() + "<Br>");
				}
			}
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>