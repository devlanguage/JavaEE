package com.foshanshop.ejb3.impl;

import java.util.Date;

import com.foshanshop.ejb3.TimerService;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

@Stateless
@Remote ({TimerService.class})
public class TimerServiceBean implements TimerService {
    
    private int count = 1;
    private @Resource SessionContext ctx;
    
    public void scheduleTimer(long milliseconds){
        count = 1;
        ctx.getTimerService().createTimer(new Date(new Date().getTime() + milliseconds),milliseconds, "大家好，这是我的第一个定时器");
    }

    @Timeout
    public void timeoutHandler(Timer timer)
    {
       System.out.println("---------------------");
       System.out.println("定时器事件发生,传进的参数为: " + timer.getInfo());
       System.out.println("---------------------");

       if (count>=5){
           timer.cancel();//如果定时器触发5次，便终止定时器           
       }
       count++;
    }
}
