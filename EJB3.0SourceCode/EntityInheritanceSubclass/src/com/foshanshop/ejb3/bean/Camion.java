package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Camion")
@PrimaryKeyJoinColumn(name="CamionID")
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
