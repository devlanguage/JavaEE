package org.cxftest.hello;

import java.util.HashMap;
import java.util.List;

import javax.jws.WebService;

@WebService
/**
 * <pre>
 *  If No @WebService annotation in web service interface class, the following exception will be thrown:
 * 
 * Exception in thread &quot;main&quot; javax.xml.ws.WebServiceException: Could not find wsdl:binding operation info for web method sayHi.
 *     at org.apache.cxf.jaxws.JaxWsClientProxy.invoke(JaxWsClientProxy.java:113)
 *     at $Proxy30.sayHi(Unknown Source)
 *     at org.cxftest.helloworld.test.ClientTestWithSpringConfig.main(ClientTestWithSpringConfig.java:15)
 * </pre>
 */
public interface HelloService {

    String sayHi(String text);

    List<String> getList();

    String[] getArray();

    HashMap<String, String> getMap();

}
