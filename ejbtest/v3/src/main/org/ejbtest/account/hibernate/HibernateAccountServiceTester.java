/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.test.account.service.AccountServiceTester.java is created on 2008-7-1
 */
package org.ejbtest.account.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.ejbtest.JndiUtil;
import org.ejbtest.account.PersistenceImpl;
import org.ejbtest.account.persistence.onetoone.Sex;
import org.ejbtest.account.persistence.query.Account;
import org.ejbtest.account.service.AccountServiceRemote1;
import org.ejbtest.account.service.AccountServiceRemote2;
import org.ejbtest.user.UserServiceRemote;
import org.hibernate.ejb.HibernatePersistence;

/**
 * 
 */
public class HibernateAccountServiceTester {

    public static void main(String[] args) {

        testJpa();
        // testEjb();
    }

    @SuppressWarnings( { "unchecked", "unused" })
    static void testJpa() {

        Map hibernatePuProviderOverriddenProperties = new HashMap();
        hibernatePuProviderOverriddenProperties.put(HibernatePersistence.AUTODETECTION, "true");
        hibernatePuProviderOverriddenProperties.put(HibernatePersistence.INTERCEPTOR, HibernateInterceptor.class.getName());

        // EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("account_unit");
        EntityManagerFactory emf = PersistenceImpl.createEntityManagerFactory("hibernate_account_unit",
                hibernatePuProviderOverriddenProperties);

        // EntityManager em1 = emf.createEntityManager();
        // javax.persistence.EntityTransaction tx = em1.getTransaction();
        // tx.begin();
        // for (int i = 1; i <= 10; ++i) {
        // Department dep1 = new Department("HR_" + i);
        // dep1.setStartDate(new java.util.Date());
        // dep1.setEndDate(new java.util.Date());
        // em1.persist(dep1);
        // if (i % 10 == 0) {
        // // flush a batch of inserts and release memory:
        // em1.flush();
        // em1.clear();
        // }
        // }
        // tx.commit();
        // em1.close();

        EntityManager em2 = emf.createEntityManager();
        javax.persistence.Query nnqListDepartments = em2.createNamedQuery("nnq_listDepartmentObjects");
        nnqListDepartments.setHint("org.hibernate.cacheable", true);
        nnqListDepartments.setHint("org.hibernate.timeout", 1000);
        nnqListDepartments.setHint("org.hibernate.jdbc.fetch_size", 100);
        // Query firstQuery = nnqListDepartments.setFirstResult(1);
        // Query maxQuery = nnqListDepartments.setMaxResults(10);
        List<Account> departmentList = nnqListDepartments.getResultList();

        // int updateResult = nnqListDepartments.executeUpdate();

        // Query flushQuery = nnqListDepartments.setFlushMode(FlushModeType.COMMIT);
        em2.close(); // session.close();
        emf.close();// sessionFactory.close();
    }

    static void testEjb() {
        // SimplePrincipal用来设置验证原则, SecurityAssociation用来根据原则进行验证,
        // org.jboss.security.SecurityAssociation.setPrincipal(new
        // org.jboss.security.SimplePrincipal("testUser".trim()));
        // org.jboss.security.SecurityAssociation.setCredential("password".trim().toCharArray());

        AccountServiceRemote1 accountServiceRemote1 = (AccountServiceRemote1) JndiUtil.getEJB("AccountService/remote1");
        accountServiceRemote1.remote1Hello("Remote1_Client");
        accountServiceRemote1.createAccount("test", "中国/西安", Sex.Female);

        AccountServiceRemote2 accountServiceRemote2 = (AccountServiceRemote2) JndiUtil.getEJB("AccountService/remote2");
        accountServiceRemote2.remote2Hello("Remote2_Client");

        UserServiceRemote userServiceRemote = (UserServiceRemote) JndiUtil.getEJB("UserService/remote");
        userServiceRemote.createUser("zhangsan", "password-1");

    }

}
