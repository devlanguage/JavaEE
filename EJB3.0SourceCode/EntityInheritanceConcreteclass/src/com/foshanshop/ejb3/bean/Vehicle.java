package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="Vehicle")
public class Vehicle implements Serializable{

    private Long id;
    private Short speed;//ËÙ¶È
    
    @Id
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
