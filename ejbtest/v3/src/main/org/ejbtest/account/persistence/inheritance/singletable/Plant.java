package org.ejbtest.account.persistence.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity(name = "ejb_plant")
@DiscriminatorValue("Plant")
public class Plant extends Biology {

    private String chlorophyl;// chlorophyl [5klCrEfil] [生化]叶绿素������

    @Column(name = "plt_chlorophyl", nullable = true, length = 30)
    public String getChlorophyl() {

        return chlorophyl;
    }

    public void setChlorophyl(String engine) {

        this.chlorophyl = engine;
    }

}
