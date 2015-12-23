package com.foshanshop.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding; 

@WebService(name = "HelloWorld",
        targetNamespace = "http://com.foshanshop.ws", serviceName = "HelloWorldService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloWorldService {
    
    @WebMethod
    public String SayHello(String name) {
        return name+ "说:这是我的第一个web服务";
    }
}
