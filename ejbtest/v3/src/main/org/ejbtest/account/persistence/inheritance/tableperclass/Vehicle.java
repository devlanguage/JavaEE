package org.ejbtest.account.persistence.inheritance.tableperclass;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "Vehicle")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "EJB_IHT_TablePerClass_Vehicle")
public class Vehicle implements Serializable {

    private Long id;
    private Short speed;//

    @Id
    @Column(name = "vh_id", columnDefinition = "Number(10,0)")
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Column(name = "vh_speed")
    public Short getSpeed() {

        return speed;
    }

    public void setSpeed(Short speed) {

        this.speed = speed;
    }

}
