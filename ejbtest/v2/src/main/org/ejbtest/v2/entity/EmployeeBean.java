package org.ejbtest.v2.entity;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ejbtest.v2.mdb.EmployeeMdb;

public class EmployeeBean implements javax.ejb.EntityBean {
    private static final long serialVersionUID = 8923797210693964683L;
    private javax.ejb.EntityContext entityContext;
    private final static Log logger = LogFactory.getLog(EmployeeMdb.class);

    private Long employeeId;
    private String name;

    // The methods in the remote interface must include java.rmi.RemoteException in their throws clause
    public void setEmployeeId(Long id) throws RemoteException {
        this.employeeId = id;
    }

    public Long getEmployeeId() throws RemoteException {
        return this.employeeId;
    }

    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    public String getName() throws RemoteException {
        return "test";
    }

    public String printDetail() throws RemoteException {
        System.out.println(employeeId + "_" + name);
        return employeeId + "_" + name;
    }

    // The result type for the ejbFindByPrimaryKey method must be the primary key type
    // The ejbFindByPrimaryKey method must be a single-object finder.
    // The return type of a finder method must be the entity bean's primary key type, or a collection of primary keys
    public Long ejbFindByPrimaryKey() throws EJBException, RemoteException {
        return employeeId;
    }

    @Override
    public void ejbLoad() throws EJBException, RemoteException {
        logger.info("public void ejbLoad() throws EJBException, RemoteException");

    }

    /**
     * *
     * 
     * <pre>
     * 用来初始化你的会话bean,可以定义多个不同参数的ejbCreate()方法来用不同的方法初始化bean。
     *  
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
     * @return
     * @throws EJBException
     * @throws RemoteException
     */
    // public void ejbCreate() throws EJBException, RemoteExceptio
    // The return type must be the entity bean's primary key type.
    public Long ejbCreate() throws EJBException, RemoteException {
        // insert into Employee;
        this.employeeId = 2L;
        this.name = "DefaultAdmin";
        if (this.entityContext.isCallerInRole("Admin")) {
            System.out.println("yes");
        }
        return 2L;
    }

    public Long ejbCreate(String ejbName) throws EJBException, RemoteException {
        // insert into Employee;
        this.employeeId = 2L;
        this.name = "DefaultAdmin";
        if (this.entityContext.isCallerInRole("Admin")) {
            System.out.println("yes");
        }
        return 2L;
    }

    /**
     * 
     * @throws EJBException
     * @throws RemoteException
     */
    // For each ejbCreate<METHOD>(...) method, the entity bean class must define a matching ejbPostCreate<METHOD>(...)
    // method.
    // The return type must be void
    public void ejbPostCreate() throws EJBException, RemoteException {
    }

    public void ejbPostCreate(String ejbName) throws EJBException, RemoteException {
    }

    /**
     * <pre>
     * ejbActivate() 
     * 当客户需要使用被钝化的bean时，容器将被钝化的bean重新导入内存，激活它们。 
     * Bean又被导致内存，这时需要重新得到bean所需要的资源。 
     * import javax.ejb.*; 
     * public class MyBean implements SessionBean { 
     * public void ejbActivate() { 
     * <open socket connections, etc...> 
     * } 
     * ... 
     * }
     * </pre>
     */
    @Override
    public void ejbActivate() throws EJBException, RemoteException {
        logger.info("public void ejbActivate() throws EJBException, RemoteException");
    }

    /**
     * <pre>
     * EjbPassivate() 如果出现太多的实例bean，EJB容器可以将它们中的一些钝化,将它们写到临时的存出空间例如数据库或文件系统。容器释放它们所申请的空间。
     * public class MyBean implements SessionBean { 
     * public void ejbPassivate() { 
     * <close socket connections, etc...> 
     * } 
     * ... 
     * }
     * </pre>
     */
    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
        logger.info("public void ejbPassivate() throws EJBException, RemoteException");

    }

    /**
     * <pre>
     * ejbRemove() 
     * 当容器将会话bean实例remove掉时，调用此方法。所有的bean都有这种方法，它没有参数，它将释放所有以分配的资源。 
     * import javax.ejb.*; 
     * public class MyBean implements SessionBean { 
     * public void ejbRemove() { 
     * <prepare for destruction> 
     * } 
     * ... 
     * } 
     * 容器可以在任何时候调用ejbRemove()方法，但如果遇到异常，则有可能禁止容器调用此方法
     * </pre>
     */
    @Override
    public void ejbRemove() throws RemoveException, EJBException, RemoteException {
        logger.info("public void ejbRemove() throws RemoveException, EJBException, RemoteException {");

    }

    @Override
    public void ejbStore() throws EJBException, RemoteException {
        logger.info("public void ejbStore() throws EJBException, RemoteException {");

    }

    @Override
    public void setEntityContext(EntityContext entityContext) throws EJBException, RemoteException {
        this.entityContext = entityContext;
    }

    @Override
    public void unsetEntityContext() throws EJBException, RemoteException {
        this.entityContext = null;
        logger.info("public void unsetEntityContext() throws EJBException, RemoteException ");

    }

}
