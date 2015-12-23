package org.ejbtest.v2.entity;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class RoleBean implements EntityBean { 

    public String ejbCreate(String name, String description) throws CreateException { 
        setName(name);
        setDescription(description); 
        return null; 
    } public 

    void ejbPostCreate(String name, String description) throws CreateException{ } 

    public abstract String getName(); 
    public abstract void setName(String name); 

    public abstract String getDescription(); 
    public abstract void setDescription(String description);

    public void setEntityContext(EntityContext context){ } 
    public void unsetEntityContext(){ } 
    public void ejbRemove(){ } 
    public void ejbLoad(){ }
    public void ejbStore(){ } 
    public void ejbPassivate(){ } 
    public void ejbActivate(){ } 
} 