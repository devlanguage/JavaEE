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
			persondao.insertPerson("黎活明", true, (short)26,formatter.parse("1980-9-30"));//添加一个人
			out.println(persondao.getPersonNameByID(1)); //取personid为1的人姓名

			Person person = persondao.getPersonByID(1); //取personid为1的person,此时的person已经脱离容器的管理
			person.setName("张小艳"); //把姓名改为张小艳
			persondao.updatePerson(person); //更新person 
			out.println("<br> personid为1的person姓名已由黎活明改为 张小艳");

			out.println("<br>============  分页显示,每页记录数为2 =========<BR>");

			String index = request.getParameter("index");
			if (index==null || "".equals(index.trim())) index = "1";

			int max = 2; //每页记录数为2
			int whichpage = Integer.parseInt(index); //第几页
			List list = persondao.getPersonList(max, whichpage);
			if (list!=null){
				Iterator it = list.iterator();
				while (it.hasNext()) {
				  Person p = (Person)it.next();
				  out.println("人员编号:"+ p.getPersonid() + " 姓名："+ p.getName() + "<Br>");
				}
			}
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>