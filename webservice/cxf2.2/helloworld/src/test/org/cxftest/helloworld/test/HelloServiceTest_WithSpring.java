package org.cxftest.helloworld.test;

import org.cxftest.hello.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class HelloServiceTest_WithSpring {

    @SuppressWarnings( { "unused" })
    public static void startTcpMonitor() {
        // Http://localhost:18081/sadfasdf
        int listenPort = 18081;

        // targetHost: Real Web Server
        String targetHost = "localhost";
        int targetPort = 8080;

        boolean embedded = true;

        // TCPMon tcpMon = new TCPMon(listenPort, targetHost, targetPort,
        // embedded);
    }

    public static void main(String[] args) {

        startTcpMonitor();
        // START SNIPPET: client
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "hello_client_beans.xml" });

        HelloService client = (HelloService) context.getBean("client.HelloService");

        String response1 = client.sayHi("Joe");
        System.out.println("Response: " + response1);

        Object response2 = client.getList();
        System.out.println("Response: " + response2);

        Object response3 = client.getArray();
        System.out.println("Response: " + response3);

        Object response4 = client.getMap();
        System.out.println("Response: " + response4);
    }
}
