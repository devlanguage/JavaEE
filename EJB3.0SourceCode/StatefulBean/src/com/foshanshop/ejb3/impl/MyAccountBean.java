package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import com.foshanshop.ejb3.MyAccount;

@SuppressWarnings("serial")
@Stateful
@Remote(MyAccount.class)
public class MyAccountBean implements MyAccount{
    private int total = 0;
    private int addresult = 0;
    public int Add(int a, int b) {
        addresult = a + b;
        return addresult;
    }

    public int getResult() {
        total += addresult;    
        return total;
    }    
}
