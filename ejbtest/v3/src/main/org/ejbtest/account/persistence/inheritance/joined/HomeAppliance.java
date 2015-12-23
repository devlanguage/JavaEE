package org.ejbtest.account.persistence.inheritance.joined;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "HomeAppliance")
@Table(name = "ejb_iht_joined_Home_Appliance")
@PrimaryKeyJoinColumn(name = "fk_commodity_id")
public class HomeAppliance extends Commodity {

    private BigDecimal price;

    @Column(nullable = true, length = 30)
    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

}
