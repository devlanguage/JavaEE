<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.OrderDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.*"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		InitialContext ctx = new InitialContext(props);
		try {			
			OrderDAO orderdao = (OrderDAO) ctx.lookup("OrderDAOBean/remote");
			orderdao.insertOrder();
			/*
			Order order = orderdao.getOrderByID(new Integer(1)); 
			out.println("�����ܷ��ã�"+ order.getAmount() +"<br>==============������=================<br>");
			if (order!=null){
				Iterator iterator = order.getOrderItems().iterator();
				while (iterator.hasNext()){
				   OrderItem SubOrder = (OrderItem) iterator.next();
				   out.println("������Ʒ:"+ SubOrder.getProductname() +"<br>");
				}
			}else{
				out.println("û���ҵ���ض���");
			}
			*/
			List list = orderdao.getAllOrder(); 
			if (list!=null){
				for(int i=0; i<list.size();i++){
					Order od = (Order) list.get(i);
					if (od!=null){
						out.println("==============�����ţ�"+ od.getOrderid() +"=================<br>");
						Iterator iterator = od.getOrderItems().iterator();
						while (iterator.hasNext()){
							 OrderItem SubOrder = (OrderItem) iterator.next();
							 out.println("������Ʒ:"+ SubOrder.getProductname() +"<br>");
						}
					}
				}
			}else{
				out.println("��ȡ���������б�");
			}
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>