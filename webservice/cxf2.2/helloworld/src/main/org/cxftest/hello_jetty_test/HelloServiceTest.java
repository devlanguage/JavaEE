package org.cxftest.hello_jetty_test;

import org.cxftest.hello.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceTest {

    public static void main(String args[]) throws Exception {
        // START SNIPPET: client
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "/org/cxftest/hello_jetty_test/hello_client_beans.xml" });

        HelloService client = (HelloService) context.getBean("client");

        String response1 = client.sayHi("Joe");
        System.out.println("Response: " + response1);
    }
}
