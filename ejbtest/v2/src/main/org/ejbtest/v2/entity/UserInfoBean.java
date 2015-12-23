package org.ejbtest.v2.entity;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class UserInfoBean implements EntityBean {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String dept;
    private String workPhone;
    private String extention;
    private String homePhone;
    private boolean isEmployee;
    public String ejbCreate(String firstName, String middleName, String lastName, String email, String dept,
            String workPhone, String extention, String homePhone, boolean isEmployee) throws CreateException {
        setEmail(email);
        setDept(dept);
        setWorkPhone(workPhone);
        setExtention(extention);
        setHomePhone(homePhone);
        setEmployee(isEmployee);
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
        return null;
    }

    public void ejbPostCreate(String firstName, String middleName, String lastName, String email, String dept,
            String workPhone, String extention, String homePhone, boolean isEmployee) throws CreateException {
    }
    public abstract LocalUser getUser();
    public abstract void setUser(LocalUser user);
    
    public abstract String getEmail();

    public abstract void setEmail(String value);

    public abstract String getFirstName();

    public abstract void setFirstName(String value);

    public abstract String getLastName();

    public abstract void setLastName(String value);

    public abstract String getMiddleName();

    public abstract void setMiddleName(String value);



    public abstract String getDept();

    public abstract void setDept(String value);

    public abstract String getExtention();

    public abstract void setExtention(String value);

    public abstract String getWorkPhone();

    public abstract void setWorkPhone(String value);

    public abstract boolean getEmployee();

    public abstract void setEmployee(boolean value);

    public abstract String getHomePhone();

    public abstract void setHomePhone(String value);

    public void setEntityContext(EntityContext context) {
    }

    public void unsetEntityContext() {
    }

    public void ejbRemove() {
    }

    public void ejbLoad() {
    }

    public void ejbStore() {
    }

    public void ejbPassivate() {
    }

    public void ejbActivate() {
    }
}
