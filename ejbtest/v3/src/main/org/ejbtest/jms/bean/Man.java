/**
 * The file org.ejbtest.jms.bean.Man.java was created by yongjie.gong on 2008-7-2
 */
package org.ejbtest.jms.bean;

import java.io.Serializable;

public class Man implements Serializable {

    private static final long serialVersionUID = -1789733418716736359L;
    private String name;
    private String address;

    public Man(String name, String address) {

        this.name = name;
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }
}
