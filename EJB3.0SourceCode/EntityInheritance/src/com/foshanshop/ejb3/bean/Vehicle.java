package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Vehicle_Hierarchy")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator",
                     discriminatorType = DiscriminatorType.STRING,
                     length=30)
@DiscriminatorValue("Vehicle")
public class Vehicle implements Serializable{

    private Long id;
    private Short speed;//ËÙ¶È
    
    @Id
    @GeneratedValue
    @Column(columnDefinition="integer")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Short getSpeed() {
        return speed;
    }
    public void setSpeed(Short speed) {
        this.speed = speed;
    }
    
}
