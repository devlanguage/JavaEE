/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.hibernate3.core.hello.persistence.Address.java is created on 2008-4-3
 */
package org.third.orm.hibernate3.core.hello.persistence;

/**
 * 
 */
public class Address {

    private long id;
    private String city;
    private String county;
    private String town;

    /**
     * @return get method for the field city
     */
    public String getCity() {

        return this.city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {

        this.city = city;
    }

    /**
     * @return get method for the field county
     */
    public String getCounty() {

        return this.county;
    }

    /**
     * @param county
     *            the county to set
     */
    public void setCounty(String county) {

        this.county = county;
    }

    /**
     * @return get method for the field id
     */
    public long getId() {

        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {

        this.id = id;
    }

    /**
     * @return get method for the field town
     */
    public String getTown() {

        return this.town;
    }

    /**
     * @param town
     *            the town to set
     */
    public void setTown(String town) {

        this.town = town;
    }
}
