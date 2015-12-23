/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.persistence.Password.java is created on 2007-10-19 上午10:04:25
 */
package org.feitian.pwdp.persistence;

/**
 * 
 */
public class Password {

    private String id;
    private String name;
    private String value;
    private String usage;
    private String description;

    public Password(String name, String value, String usage) {

        this.name = name;
        this.value = value;
        this.usage = usage;
    }

    public Password() {

    }

    /**
     * @return get method for the field description
     */
    public String getDescription() {

        return this.description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {

        this.description = description;
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

    /**
     * @return get method for the field usage
     */
    public String getUsage() {

        return this.usage;
    }

    /**
     * @param usage
     *            the usage to set
     */
    public void setUsage(String usage) {

        this.usage = usage;
    }

    /**
     * @return get method for the field value
     */
    public String getValue() {

        return this.value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {

        this.value = value;
    }

    /**
     * @return get method for the field id
     */
    public String getId() {

        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {

        this.id = id;
    }
}
