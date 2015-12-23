package org.ejbtest.v2.entity;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface Employee extends EJBObject {
    public void setEmployeeId(Long name) throws RemoteException;
    public Long getEmployeeId() throws RemoteException;
    
    public void setName(String name) throws RemoteException;
    public String getName() throws RemoteException;
    
    public String printDetail() throws RemoteException;
}
