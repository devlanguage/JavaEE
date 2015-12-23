package com.foshanshop.ejb3.impl;

import com.foshanshop.ejb3.HelloChina;
import com.foshanshop.ejb3.HelloChinaRemote;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Remote ({HelloChinaRemote.class})
@Local(HelloChina.class)
@Interceptors({HelloInterceptor.class}) 
public class HelloChinaBean implements HelloChina,HelloChinaRemote {

    public String SayHello(String name) {
        return name +"˵�����!�й�.";
    }

    public String Myname() {        
        return "���Ƿ�ɽ��";
    }
}
