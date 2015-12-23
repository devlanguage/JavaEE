package org.ejbtest.account.persistence.inheritance.singletable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

// SINGLE_TABLE:A single table per class hierarchy
@SuppressWarnings("serial")
@Entity
@Table(name = "EJB_IHT_SingleTable_Biology")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorValue("Biology")
public class Biology implements Serializable {

    private Long id;
    private Short speed;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "blg_id", columnDefinition = "Number(10,0)")
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Column(name = "blg_speed")
    public Short getSpeed() {

        return speed;
    }

    public void setSpeed(Short speed) {

        this.speed = speed;
    }

}
