/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.ejbtest.user.persistence.UserInfo.java is created on 2008-7-1
 */
package org.ejbtest.user.persistence;

import java.io.Serializable;

/**
 * 
 */
public class User implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -9153165624241332883L;

    private int id;
    private String name;
    private String password;

    public User(String name2, String password2) {

        this.name = name2;
        this.password = password2;
        this.id = (int) Math.random() * 100000;
    }

    /**
     * @return get method for the field email
     */
    public String getPassword() {

        return this.password;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setPassword(String email) {

        this.password = email;
    }

    /**
     * @return get method for the field id
     */
    public int getId() {

        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {

        this.id = id;
    }

    /**
     * @return get method for the field name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return new StringBuffer(this.getClass().getSimpleName()).append(":[id=").append(this.id).append(", name=")
                .append(this.name).append(", password=").append(this.password).toString();
    }

}
