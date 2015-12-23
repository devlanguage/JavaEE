package org.ejbtest.account.persistence.inheritance.joined;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ejb_iht_joined_Commodity")
public class Commodity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "commodity_id", columnDefinition = "Number(10,0)")
    private Long commodityId;

    @Column(name = "commodity_name", nullable = false)
    private String name;

    public Long getCommodityId() {

        return commodityId;
    }

    public void setCommodityId(Long id) {

        this.commodityId = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String speed) {

        this.name = speed;
    }

}
