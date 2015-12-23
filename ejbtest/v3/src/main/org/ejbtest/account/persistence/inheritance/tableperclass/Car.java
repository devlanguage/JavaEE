package org.ejbtest.account.persistence.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "Car")
@Table(name = "EJB_IHT_TablePerClass_Car")
public class Car extends Vehicle {

    private String engine;

    @Column(name = "card_speed", nullable = true, length = 30)
    public String getEngine() {

        return engine;
    }

    public void setEngine(String engine) {

        this.engine = engine;
    }

}
