/**
 * The file org.ejbtest.communication.service.CommunicationServiceInterceptor.java was created by yongjie.gong on 2008-7-3
 */
package org.ejbtest.communication.service.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author feiye
 * 
 */
public class CommunicationServiceInterceptor {

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {

        System.out.println("*** HelloInterceptor intercepting");
        long start = System.currentTimeMillis();

        System.out.println("Calling the method: " + ctx.getMethod());

        long time = System.currentTimeMillis() - start;
        System.out.println("It take:" + time + "ms");
        return ctx.proceed();
    }
}
