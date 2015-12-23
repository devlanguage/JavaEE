package org.cxftest.helloworld.test;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.cxftest.hello.HelloService;

public class HelloServiceTest_Pojo {

    public static void main(String args[]) throws Exception {
        ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
        factory.setServiceClass(HelloService.class);
        factory.setAddress("http://localhost:8080/test/HelloService");
        // factory.getServiceFactory().setDataBinding(new AegisDatabinding());
        HelloService client = (HelloService) factory.create();
        System.out.println("Invoke sayHi()....");
        System.out.println(client.sayHi(System.getProperty("user.name")));
        System.exit(0);
    }
}
