package org.ejbtest.v2.stateless;

import java.rmi.RemoteException;

import javax.ejb.CreateException;

public interface EmployeeServiceHome extends javax.ejb.EJBHome {

    public EmployeeService create() throws RemoteException, CreateException;
    // @Override
    // public EJBMetaData getEJBMetaData() throws RemoteException {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public HomeHandle getHomeHandle() throws RemoteException {
    //
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // @Override
    // public void remove(Handle arg0) throws RemoteException, RemoveException {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void remove(Object arg0) throws RemoteException, RemoveException {
    // // TODO Auto-generated method stub
    //
    // }

}
