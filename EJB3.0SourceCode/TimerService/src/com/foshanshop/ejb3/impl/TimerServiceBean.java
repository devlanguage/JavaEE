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
        ctx.getTimerService().createTimer(new Date(new Date().getTime() + milliseconds),milliseconds, "��Һã������ҵĵ�һ����ʱ��");
    }

    @Timeout
    public void timeoutHandler(Timer timer)
    {
       System.out.println("---------------------");
       System.out.println("��ʱ���¼�����,�����Ĳ���Ϊ: " + timer.getInfo());
       System.out.println("---------------------");

       if (count>=5){
           timer.cancel();//�����ʱ������5�Σ�����ֹ��ʱ��           
       }
       count++;
    }
}
