<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.TeacherDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.*"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		InitialContext ctx = new InitialContext(props);
		try {			
			TeacherDAO teacherdao = (TeacherDAO) ctx.lookup("TeacherDAOBean/remote");
			teacherdao.insertTeacher("����ʦ",new String[]{"��С��","��С��","����"});
	
			Teacher teacher = teacherdao.getTeacherByID(new Integer(1)); 
			
			if (teacher!=null){
				out.println("======= ��ȡ���Ϊ1����ʦ������"+ teacher.getTeacherName() +" ======<br>");
				Iterator iterator = teacher.getStudents().iterator();
				while (iterator.hasNext()){
				   Student student = (Student) iterator.next();
				   out.println("&nbsp;&nbsp;����ѧ��:"+ student.getStudentName() +"<br>");
				}
			}else{
				out.println("û���ҵ����Ϊ1����ʦ<br>");
			}
	
			Student student = teacherdao.getStudentByID(new Integer(1)); 
			if (student!=null){
				out.println("======= ��ȡ���Ϊ1��ѧ��������"+ student.getStudentName() +" ======<br>");
				Iterator iterator = student.getTeachers().iterator();
				while (iterator.hasNext()){
				   Teacher tc = (Teacher) iterator.next();
				   out.println("&nbsp;&nbsp;������ʦ:"+ tc.getTeacherName() +"<br>");
				}
			}else{
				out.println("û���ҵ����Ϊ1��ѧ��<br>");
			}			

		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>