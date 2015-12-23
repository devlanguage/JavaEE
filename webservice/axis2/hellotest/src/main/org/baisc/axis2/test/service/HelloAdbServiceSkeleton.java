/**
 * HelloAdbServiceSkeleton.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.3 Built on : Aug 10, 2007
 * (04:45:47 LKT)
 */
package org.baisc.axis2.test.service;

import java.lang.reflect.Proxy;
import java.util.List;

import org.basic.axis2.helloadb.bean.Share;
import org.basic.axis2.helloadb.service.HelloAdbService;

/**
 * HelloAdbServiceSkeleton java skeleton for the axisService
 */
public class HelloAdbServiceSkeleton {

    private static HelloAdbService proxy = null;
    static {
        proxy = (HelloAdbService) Proxy.newProxyInstance(HelloAdbServiceSkeleton.class
                .getClassLoader(), new Class[] { HelloAdbService.class },
                new HelloAdbServiceHandler());
    }

    public String hello(String user) {

        return proxy.hello(user);
    }

    public Share getShare(int index) {

        return proxy.getShare(index);
    }

    public List<Share> getAllShareList() {

        return proxy.getAllShareList();
    }

}
