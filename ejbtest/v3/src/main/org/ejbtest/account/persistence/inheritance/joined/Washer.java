package org.ejbtest.account.persistence.inheritance.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "Washer")
@Table(name = "ejb_iht_joined_Washer")
@PrimaryKeyJoinColumn(name = "fk_commodity_id")
public class Washer extends HomeAppliance {
    @Column(nullable = true, length = 30)
    private String container;

   
    public String getContainer() {

        return container;
    }

    public void setContainer(String container) {

        this.container = container;
    }

}
