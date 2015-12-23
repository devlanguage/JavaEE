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
			Vehicle vehicle = entityinheritancedao.getLastVehicle(); //ȡ���һ��Vehicle
			out.println("Vehicle�ࣺ�ٶ�=");
			out.println(vehicle.getSpeed());

			Car car = entityinheritancedao.getLastCar(); //ȡ���һ��Car
			out.println("<br>Car�ࣺ�ٶ�=");
			out.println(car.getSpeed()+"; ������="+ car.getEngine());

			Camion camion = entityinheritancedao.getLastCamion(); //ȡ���һ��Camion
			out.println("<br>Camion�ࣺ�ٶ�=");
			out.println(camion.getSpeed()+ "; ������="+ camion.getEngine()+ "; ��װ��="+  camion.getContainer());
			/* ��������ɾ�����м�¼
            entityinheritancedao.deleteVehicle();
			*/

		} catch (Exception e) {
			out.println(e.getMessage());
		}
%>