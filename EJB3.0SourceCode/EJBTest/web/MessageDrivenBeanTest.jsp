<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="javax.naming.*, java.text.*, javax.jms.*, java.util.Properties"%>
<%
    QueueConnection cnn = null;
    QueueSender sender = null;
    QueueSession sess = null;
    Queue queue = null;

    try {
	  Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");	
      InitialContext ctx = new InitialContext(props);
      QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");
      cnn = factory.createQueueConnection();
      sess = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	  queue = (Queue) ctx.lookup("queue/foshanshop");
    } catch (Exception e) {
		out.println(e.getMessage());
    }

    TextMessage msg = sess.createTextMessage("��ɽ�����ã������ҵĵ�һ����Ϣ����Bean");
    sender = sess.createSender(queue);
    sender.send(msg);
    sess.close ();
	out.println("��Ϣ�Ѿ����ͳ�ȥ�ˣ�����Ե�JBoss����̨�鿴Bean�����");
%>