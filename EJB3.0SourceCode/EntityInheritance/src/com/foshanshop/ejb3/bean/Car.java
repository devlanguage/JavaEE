package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle{
    
    private String engine;//·¢¶¯»ú

    @Column(nullable=true,length=30)
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
    
}
