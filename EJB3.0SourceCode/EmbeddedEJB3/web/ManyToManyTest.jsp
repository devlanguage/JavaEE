<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.TeacherDAO,
				com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.*,
				com.foshanshop.conf.Constants"%>
<%
		try {		
		    InitialContext ctx = Constants.getInitialContext();
			TeacherDAO teacherdao = (TeacherDAO) ctx.lookup("TeacherDAOBean/remote");
			teacherdao.insertTeacher("李老师",new String[]{"张小红","朱小光","龚利"});
	
			Teacher teacher = teacherdao.getTeacherByID(new Integer(1)); 
			
			if (teacher!=null){
				out.println("======= 获取编号为1的老师姓名："+ teacher.getTeacherName() +" ======<br>");
				Iterator iterator = teacher.getStudents().iterator();
				while (iterator.hasNext()){
				   Student student = (Student) iterator.next();
				   out.println("&nbsp;&nbsp;他的学生:"+ student.getStudentName() +"<br>");
				}
			}else{
				out.println("没有找到编号为1的老师<br>");
			}
	
			Student student = teacherdao.getStudentByID(new Integer(1)); 
			if (student!=null){
				out.println("======= 获取编号为1的学生姓名："+ student.getStudentName() +" ======<br>");
				Iterator iterator = student.getTeachers().iterator();
				while (iterator.hasNext()){
				   Teacher tc = (Teacher) iterator.next();
				   out.println("&nbsp;&nbsp;他的老师:"+ tc.getTeacherName() +"<br>");
				}
			}else{
				out.println("没有找到编号为1的学生<br>");
			}			

		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>