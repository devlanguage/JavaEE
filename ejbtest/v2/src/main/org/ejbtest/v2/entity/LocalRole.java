package org.ejbtest.v2.entity;

import javax.ejb.EJBLocalObject;


public interface LocalRole extends EJBLocalObject {
    public abstract String getName(); 
    public abstract String getDescription(); 
}
 