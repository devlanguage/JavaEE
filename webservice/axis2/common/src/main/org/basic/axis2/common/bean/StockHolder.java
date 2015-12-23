/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.axis2.helloxmlbeans.bean.StockHolder.java is created on 2008-2-1
 */
package org.basic.axis2.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StockHolder implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7340853066496831408L;
    private String name;
    private List<Share> shares = new ArrayList<Share>();

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

    /**
     * @return get method for the field shares
     */
    public List<Share> getShares() {

        return this.shares;
    }

    /**
     * @param shares
     *            the shares to set
     */
    public void setShares(List<Share> shares) {

        this.shares = shares;
    }

}
