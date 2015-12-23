package org.ejbtest.v2.entity;

import javax.ejb.EJBLocalObject;

public interface LocalUser extends EJBLocalObject {

    public Long getUserId();
    public String getEmail();
    public String getPassword();
    public LocalUserInfo getUserInfo();
    public void setUserInfo(LocalUserInfo userInfo);
}