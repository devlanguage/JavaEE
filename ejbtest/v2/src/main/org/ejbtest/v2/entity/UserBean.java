package org.ejbtest.v2.entity;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;

public abstract class UserBean implements EntityBean {
    private Long userId;
    private String email;
    private String password;
    public abstract Long getUserId();
    public abstract void setUserId(Long userId);
    public abstract String getEmail();
    public abstract void setEmail(String email);

    public abstract String getPassword();

    public abstract void setPassword(String password);

    public abstract LocalUserInfo getUserInfo();

    public abstract void setUserInfo(LocalUserInfo userInfo);

    public Long ejbCreate(String email, String password) throws CreateException {
        return userId;
    }

    public void ejbPostCreate(String email, String password) throws CreateException {
    }
}