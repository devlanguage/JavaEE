package org.ejbtest.account.persistence.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity(name = "ejb_watermelon")
@DiscriminatorValue("Watermelon")
public class Watermelon extends Plant {

    private String color;//

    @Column(name = "wmln_color", nullable = true, length = 30)
    public String getColor() {

        return color;
    }

    public void setColor(String container) {

        this.color = container;
    }

}
