/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.account.service.AccountServiceImpl.java is created on 2008-7-1
 */
package org.ejbtest.account.service;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.ejbtest.account.persistence.onetoone.Sex;
import org.ejbtest.account.persistence.query.Account;
import org.ejbtest.account.vo.AccountVo;
import org.ejbtest.user.UserServiceLocal;
import org.ejbtest.user.persistence.User;
import org.jboss.annotation.ejb.Clustered;
import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.ejb.RemoteBinding;
import org.jboss.annotation.ejb.RemoteBindings;

/**
 * 
 */

// @SuppressWarnings("serial")
@Stateless
@Remote( { AccountServiceRemote1.class, AccountServiceRemote2.class })
@RemoteBindings( { @RemoteBinding(jndiBinding = "AccountService/remote1"),
        @RemoteBinding(jndiBinding = "AccountService/remote2") })
@Local( { AccountServiceLocal.class })
@LocalBinding(jndiBinding = "AccountService/local")
@Clustered
// @SecurityDomain: 这样将从users.properties中读取Authentication信息:
public class AccountServiceBean implements AccountServiceLocal, AccountServiceRemote1, AccountServiceRemote2 {

    @PersistenceContext(name = "pu_name1", unitName = "hibernate_account_unit")
    protected EntityManager em;

    @EJB(name = "UserService/local")
    private UserServiceLocal userServiceLocal;

    @Resource(mappedName = "java:/OracleDS1")
    private DataSource ds;

    @Resource(mappedName = "java:/Mail")
    javax.mail.Session session;

    @RolesAllowed( { "admin" })
    public String AdminUserMethod() {

        return "@RolesAllowed( {\"AdminUser\" })()public String AdminUserMethod() {";
    }

    /**
     * @return get method for the field em
     */
    public EntityManager getEm() {

        return this.em;
    }

    /**
     * @param em
     *            the em to set
     */
    public void setEm(EntityManager em) {

        this.em = em;
    }

    @RolesAllowed( { "ramdon" })
    public String DepartmentUserMethod() {

        return "@RolesAllowed( { \"DepartmentUser\" }) public String DepartmentUserMethod()";
    }

    @PermitAll
    public String AnonymousUserMethod() {
        System.out.println("@PermitAll String AnonymousUserMethod()");
        return "@PermitAll String AnonymousUserMethod()";
    }

    public List<User> listUsers() {

        List<User> users = userServiceLocal.listUsers();
        System.out.println("\n userCount=" + users.size() + "\n");
        // for (User u : users) {
        // System.out.println(u);
        // }'
        return users;
    }

    @Override
    @javax.ejb.TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void localHello(String guest, int number) {

    }

    @Override
    @RolesAllowed( { "JBossAdmin" })
    public String remote1Hello(String client) {
        AnonymousUserMethod();
        DepartmentUserMethod();
        return this.getClass().getSimpleName();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @RolesAllowed( { "admin" })
    @Override
    public String remote2Hello(String guest) {

        System.out.println(em);
        System.out.println(userServiceLocal);
        System.out.println(ds);
        System.out.println(session);

        Object o = em.find(Account.class, 1);
        System.out.println("account:" + o);

        System.out.println("hello, friends:" + guest);
        return this.getClass().getSimpleName();

    }

    @Override
    public AccountVo createAccount(String name, String address, Sex sex) {
        javax.persistence.Query q1 = em.createQuery("from EntityLifecycle");
        List entityLives = q1.getResultList();
        System.out.println(entityLives);

        tx00_Mandatory();
        tx01_Required();
        tx02_Require_New();
        tx03_Supports();
        tx04_Not_Supported();
        tx05_Never();
        AccountVo accountVo = new AccountVo();
        return accountVo;
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void tx00_Mandatory() // If no tx now, Throws Exception
    {
        Account account = new Account("tx00_Mandatory");
        em.merge(account);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void tx01_Required()// If have Tx, Join; Else, create new Tx
    {
        Account account = new Account("tx01_Required");
        em.persist(account);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void tx02_Require_New() // Suspend Current Tx, Create new Tx
    {
        Account account = new Account("tx02_Require_New");
        em.persist(account);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void tx03_Supports()// if have Tx, join; Else, execute in non-Tx
    {
        Account account = new Account("tx03_Supports");
        em.persist(account);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void tx04_Not_Supported()// Suspend Current Tx, Execute in non-Tx
    {
        Account account = new Account("tx04_Not_Supported");
        em.persist(account);
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void tx05_Never()// If in tx now, Throws Exception
    {
        Account account = new Account("tx05_Never");
        em.persist(account);
    }

}
