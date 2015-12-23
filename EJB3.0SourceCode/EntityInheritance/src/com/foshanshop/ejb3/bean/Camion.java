package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Camion")
public class Camion extends Car{
    private String container;//¼¯×°Ïä

    @Column(nullable=true,length=30)
    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }
    
}
