package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class AirtLinePK implements Serializable {
    private String leavecity;
    private String arrivecity;
    
    public AirtLinePK(){}
    
    public AirtLinePK(String leavecity, String arrivecity) {
        this.leavecity = leavecity;
        this.arrivecity = arrivecity;
    }

    @Column(nullable=false,length=3,name="LEAVECITY")
    public String getLeavecity() {
        return leavecity;
    }
    public void setLeavecity(String leavecity) {
        this.leavecity = leavecity;
    }
    
    @Column(nullable=false,length=3,name="ARRIVECITY")
    public String getArrivecity() {
        return arrivecity;
    }
    public void setArrivecity(String arrivecity) {
        this.arrivecity = arrivecity;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirtLinePK)) return false;

        final AirtLinePK airtLinePK = (AirtLinePK) o;

        if (leavecity==null || !leavecity.equals(airtLinePK.getLeavecity())) return false;
        if (arrivecity==null || !arrivecity.equals(airtLinePK.getArrivecity())) return false;
        return true;

    }
    public int hashCode() {
        int result;
        result = leavecity.hashCode();
        result = 29 * result + arrivecity.hashCode();
        return result;
    }
    
}
