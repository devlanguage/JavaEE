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

    TextMessage msg = sess.createTextMessage("佛山人您好，这是我的第一个消息驱动Bean");
    sender = sess.createSender(queue);
    sender.send(msg);
    sess.close ();
	out.println("消息已经发送出去了，你可以到JBoss控制台查看Bean的输出");
%>