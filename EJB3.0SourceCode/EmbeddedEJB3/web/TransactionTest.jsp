<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.TransactionDAO,
				javax.naming.*,
				com.foshanshop.conf.Constants"%>
<%
		try {
		    InitialContext ctx = Constants.getInitialContext();
			TransactionDAO transactiondao = (TransactionDAO) ctx.lookup("TransactionDAOBean/remote");
			transactiondao.insertProduct("����", new Float("1200"), false);
			transactiondao.ModifyProductName("�������", true);
			out.println("ִ�����");
		} catch (Exception e) {
			out.println(e.getMessage());			
		}
%>