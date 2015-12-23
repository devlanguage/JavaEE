package org.ejbtest.v2.stateless;

public interface EmployeeService extends javax.ejb.EJBObject {
    public String createEmployee(String name) throws java.rmi.RemoteException;
}
