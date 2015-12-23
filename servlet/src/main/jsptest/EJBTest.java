package jsptest;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class EJBTest {

  /**
   * @param args
   *          the command line arguments
   */
  public static void main(String[] args) throws Exception {
    // TODO code application logic here
    Properties props = new Properties();
    props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
    props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
    props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
    props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost"); // host
    props.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); // EJB Port
    Context ctx = new InitialContext(props);
    //
    // HelloBeanRemote hr =
    // (HelloBeanRemote) ctx.lookup(HelloBeanRemote.class.getName());
    // System.out.println(hr.getClass().getName());
    //
    // System.out.println(hr.sayHello("zbs"));
  }
}
