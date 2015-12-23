<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.EntityInheritanceDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.Properties"%>
<%
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	

		InitialContext ctx = new InitialContext(props);
		try {			
		    EntityInheritanceDAO entityinheritancedao = (EntityInheritanceDAO) ctx.lookup("EntityInheritanceDAOBean/remote");			
			entityinheritancedao.initializeData();
			Vehicle vehicle = entityinheritancedao.getLastVehicle(); //取最后一个Vehicle
			out.println("Vehicle类：速度=");
			out.println(vehicle.getSpeed());

			Car car = entityinheritancedao.getLastCar(); //取最后一个Car
			out.println("<br>Car类：速度=");
			out.println(car.getSpeed()+"; 发动机="+ car.getEngine());

			Camion camion = entityinheritancedao.getLastCamion(); //取最后一个Camion
			out.println("<br>Camion类：速度=");
			out.println(camion.getSpeed()+ "; 发动机="+ camion.getEngine()+ "; 集装箱="+  camion.getContainer());
			/* 下面语句会删除所有记录
            entityinheritancedao.deleteVehicle();
			*/

		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>