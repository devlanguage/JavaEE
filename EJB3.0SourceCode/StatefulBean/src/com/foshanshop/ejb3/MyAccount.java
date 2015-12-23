package com.foshanshop.ejb3;

import java.io.Serializable;

public interface MyAccount extends Serializable {
    public int Add(int a, int b);
    public int getResult() ;
}
