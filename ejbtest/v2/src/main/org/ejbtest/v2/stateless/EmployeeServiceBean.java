package org.ejbtest.v2.stateless;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionContext;

public class EmployeeServiceBean implements javax.ejb.SessionBean {
    private static final long serialVersionUID = -8947672016269742532L;

    public String createEmployee(String name) throws java.rmi.RemoteException {
        System.out.println("Call createEmployee: ");
        return "Hello: " + name;
    }

    public void ejbCreate() throws EJBException, RemoteException {

    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {
        // TODO Auto-generated method stub

    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
        // TODO Auto-generated method stub

    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {
        // TODO Auto-generated method stub

    }

    SessionContext sessionCtx;

    @Override
    public void setSessionContext(SessionContext sCtx) throws EJBException, RemoteException {
        sessionCtx = sCtx;

    }

}
