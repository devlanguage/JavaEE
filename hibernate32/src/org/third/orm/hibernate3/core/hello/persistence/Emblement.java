/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.hibernate3.core.hello.persistence.Emblement.java is created on 2008-4-7
 */
package org.third.orm.hibernate3.core.hello.persistence;

import java.math.BigDecimal;


/**
 * 
 */
public class Emblement {

    private long emblementId;
    private String emblementName;
    private BigDecimal output;
    private String unit;
    private Person person;

    /**
     * @return get method for the field emblementId
     */
    public long getEmblementId() {

        return this.emblementId;
    }

    /**
     * @param emblementId
     *            the emblementId to set
     */
    public void setEmblementId(long emblementId) {

        this.emblementId = emblementId;
    }

    /**
     * @return get method for the field emblementName
     */
    public String getEmblementName() {

        return this.emblementName;
    }

    /**
     * @param emblementName
     *            the emblementName to set
     */
    public void setEmblementName(String emblementName) {

        this.emblementName = emblementName;
    }

    /**
     * @return get method for the field output
     */
    public BigDecimal getOutput() {

        return this.output;
    }

    /**
     * @param output
     *            the output to set
     */
    public void setOutput(BigDecimal output) {

        this.output = output;
    }

    /**
     * @return get method for the field person
     */
    public Person getPerson() {

        return this.person;
    }

    /**
     * @param person
     *            the person to set
     */
    public void setPerson(Person person) {

        this.person = person;
    }

    /**
     * @return get method for the field unit
     */
    public String getUnit() {

        return this.unit;
    }

    /**
     * @param unit
     *            the unit to set
     */
    public void setUnit(String unit) {

        this.unit = unit;
    }

    @Override
    public String toString() {

        return new StringBuffer(this.getClass().getSimpleName()).append(":[emblementId=").append(
                this.emblementId).append(", emblementName=").append(this.emblementName).append(
                ",output=").append(this.output).append(" ").append(this.unit).toString();

    }
}
