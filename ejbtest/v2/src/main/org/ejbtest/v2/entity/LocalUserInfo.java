package org.ejbtest.v2.entity;

import javax.ejb.EJBLocalObject;

public interface LocalUserInfo extends EJBLocalObject {
    public abstract String getEmail();

    public abstract LocalUser getUser();

    public abstract void setUser(LocalUser user);

    public abstract String getDept();

    public abstract void setDept(String value);

    public abstract String getWorkPhone();

    public abstract void setWorkPhone(String value);

    public abstract String getExtention();

    public abstract void setExtention(String value);

    public abstract boolean getEmployee();

    public abstract void setEmployee(boolean value);

    public abstract String getHomePhone();

    public abstract void setHomePhone(String value);

    public abstract String getFirstName();

    public abstract void setFirstName(String value);

    public abstract String getLastName();

    public abstract void setLastName(String value);

    public abstract String getMiddleName();

    public abstract void setMiddleName(String value);
}
