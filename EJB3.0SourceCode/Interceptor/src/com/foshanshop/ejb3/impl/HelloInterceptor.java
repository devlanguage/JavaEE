package com.foshanshop.ejb3.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class HelloInterceptor {

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {
        System.out.println("*** HelloInterceptor intercepting");
        long start = System.currentTimeMillis();
        try{
            if (ctx.getMethod().getName().equals("SayHello")){
                System.out.println("*** SayHello �Ѿ�������! *** " );
            }            
            if (ctx.getMethod().getName().equals("Myname")){
                System.out.println("*** Myname �Ѿ�������! *** " );
            }            
            return ctx.proceed();
        }catch (Exception e) {
            throw e;
            
        }finally {
            long time = System.currentTimeMillis() - start;    
            System.out.println("��ʱ:"+ time + "ms");
        }
    }
}
