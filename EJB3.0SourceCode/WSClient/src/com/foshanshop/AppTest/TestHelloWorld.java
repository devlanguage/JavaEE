package com.foshanshop.AppTest;

import ws.foshanshop.com.HelloWorld;
import ws.foshanshop.com.HelloWorldProxy;

public class TestHelloWorld {
    
    public static void main(String[] args) {       
       try {
           HelloWorldProxy proxy = new HelloWorldProxy();
           HelloWorld port = (HelloWorld) proxy.getHelloWorld();
           String out = port.sayHello("ÀèÃ÷");
           System.out.println("½á¹û:"+out);  
        } catch (Exception e) {
            e.printStackTrace();
        }         
    }
}
