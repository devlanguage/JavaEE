<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.TransactionDAO,
				javax.naming.*,
				com.foshanshop.conf.Constants"%>
<%
		try {
		    InitialContext ctx = Constants.getInitialContext();
			TransactionDAO transactiondao = (TransactionDAO) ctx.lookup("TransactionDAOBean/remote");
			transactiondao.insertProduct("电脑", new Float("1200"), false);
			transactiondao.ModifyProductName("数码相机", true);
			out.println("执行完成");
		} catch (Exception e) {
			out.println(e.getMessage());			
		}
%>