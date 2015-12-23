package org.cxftest.helloworld.test;

import org.cxftest.user.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class UserServiceTest_WithSpring {

    public static void main(String[] args) {
        // START SNIPPET: client
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "hello_client_beans.xml" });

        UserService client = (UserService) context.getBean("client.UserService");

        Object response1 = client.sayStudent("Joe");
        System.out.println("Response: " + response1);

        Object response2 = client.getUsers();
        System.out.println("Response: " + response2);

        Object response3 = client.listUsers();
        System.out.println("Response: " + response3);

    }

}
