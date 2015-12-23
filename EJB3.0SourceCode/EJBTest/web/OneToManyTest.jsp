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
			out.println("订单总费用："+ order.getAmount() +"<br>==============订单项=================<br>");
			if (order!=null){
				Iterator iterator = order.getOrderItems().iterator();
				while (iterator.hasNext()){
				   OrderItem SubOrder = (OrderItem) iterator.next();
				   out.println("订购产品:"+ SubOrder.getProductname() +"<br>");
				}
			}else{
				out.println("没有找到相关订单");
			}
			*/
			List list = orderdao.getAllOrder(); 
			if (list!=null){
				for(int i=0; i<list.size();i++){
					Order od = (Order) list.get(i);
					if (od!=null){
						out.println("==============订单号："+ od.getOrderid() +"=================<br>");
						Iterator iterator = od.getOrderItems().iterator();
						while (iterator.hasNext()){
							 OrderItem SubOrder = (OrderItem) iterator.next();
							 out.println("订购产品:"+ SubOrder.getProductname() +"<br>");
						}
					}
				}
			}else{
				out.println("获取不到订单列表");
			}
		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>