package com.foshanshop.ejb3.impl;

import com.foshanshop.ejb3.LifeCycle;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote ({LifeCycle.class})
public class LifeCycleBean implements LifeCycle {

    public String Say() {
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return "这是会话Bean生命周期应用例子";
    }

    @Init
    public void initialize () {
      System.out.println("initialize()方法被调用");
    }   
    
    @PostConstruct
    public void Construct () {
      System.out.println("Construct()方法被调用");
    }

    @PreDestroy
    public void exit () {
      System.out.println("exit()方法被调用");
    }

    @PrePassivate
    public void serialize () {
      System.out.println("serialize()方法被调用");
    }

    @PostActivate
    public void activate () {
      System.out.println("activate()方法被调用");
    }

    @Remove
    public void stopSession () {
      System.out.println("stopSession()方法被调用"); 
      //调用该方法以通知容器，移除该bean实例、终止会话。方法体可以是空的。
    }

}
