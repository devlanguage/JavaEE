package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Car")
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
