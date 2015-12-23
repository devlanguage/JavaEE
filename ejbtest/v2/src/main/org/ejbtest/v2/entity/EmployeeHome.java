package org.ejbtest.v2.entity;

import java.rmi.RemoteException;

import javax.ejb.CreateException;

public interface EmployeeHome extends javax.ejb.EJBHome {

    public Employee create() throws RemoteException, CreateException;

    /**
     * <pre>
     * ejbCreate()方法是容器可以调用的callback方法，客户端代码不能调用它，因为客户端不能直接处理beans??他们必须通过容器，
     * 但是客户端必须采用某种方法向ejbCreate方法传递参数，客户端提供初始化参数。Home接口是客户端用来初始化调用的接口工厂
     * 
     * 你必须在home接口中复制每一个ejbCreate()方法，例如：如果在bean类中你有下面的ejbCreate方法
     * public void ejbCreate(int i) throws ... 
     * 那么你必须在你的home接口里有下面的create()方法 
     * public void create(int i) throws ... 
     * 客户端调用home接口中的create()方法，将参数传递给ejbCreate()
     * </pre>
     * 
     * @param ejbName
     * @return
     * @throws RemoteException
     * @throws CreateException
     */
    public Employee create(String ejbName) throws RemoteException, CreateException;

}
